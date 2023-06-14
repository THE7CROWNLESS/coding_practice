package leetcode;

public class FindFirstToEnd {
    public int[] searchRange(int[] nums, int target) {

        int start = search(nums, target, true);
        int end = search(nums, target,false);

        return new int[]{start,end};
    }

    public int search(int[] nums, int target, boolean isLeft){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = 0;
            if (isLeft){
                mid = (left + right)/2;
            }else {
                mid = (left + right + 1)/2;
            }

            if(nums[mid]>target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                if (isLeft){
                    right = mid;

                }else {
                    left = mid;

                }
            }
        }
        if(right < 0 || right > nums.length - 1 || nums[right] != target){
            return -1;
        }else {
            return right;
        }
    }
}
