package leetcode;

//双指针：1、两次遍历（暴力解），寻求减少遍历次数；2、快慢/两头 想法。
// 关键在于以短边计算：从该短边到最远位置的值都被记录了（不会更大），则移动短边
//有点贪心思想?
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int minSide =  0;
        int res = 0;
        int area = 0;

        while (left < right){
            minSide = Math.min(height[left],height[right]);
            area = (right - left) * minSide;
            if (res < area){
                res = area;
            }
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
