package leetcode;
//一定一部分有序，另一部分可能有序
//定理一：只有在顺序区间内才可以通过区间两端的数值判断target是否在其中。
//定理二：判断顺序区间还是乱序区间，只需要对比 left 和 right 是否是顺序对即可，left <= right，顺序区间，否则乱序区间。
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            //若为有序的一部分
            if (nums[mid] >= nums[left]) {
                //比较target，判断target在那一部分
                if(target == nums[mid]){
                    return mid;
                }else if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else {  //另一部分有序
                if(target == nums[mid]){
                    return mid;
                }else if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        if(nums[right] == target){
            return  right;
        }else{
            return -1;
        }
    }
}
