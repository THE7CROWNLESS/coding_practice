package leetcode;

public class TrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = left + 1;
        int res = 0;
        for (int i = 1 ; i < n; i++) {
            if (height[i] < height[left]) {
                right++;
            }else {
                int tmp = left + 1;
                while (tmp < right){
                    res = res + (height[left] - height[tmp]);
                    tmp++;
                }
                left = right;
                right = left + 1;
            }
        }
        right = n - 1;
        left = right - 1;
        for (int i = right - 1 ; i >= 0; i--) {
            if (height[i] < height[right]) {
                left--;
            }else {
                int tmp =right - 1;
                while (tmp > left){
                    res = res + (height[right] - height[tmp]);
                    tmp--;
                }
                right = left;
                left = right - 1;
            }
        }
        return res;
    }
}
