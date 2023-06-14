package leetcode;

//二分查找的目标：可以是某值（存在与不存在），也可以是一个元素范围

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
                //等于时，依然移动，由于两侧移动的限制，最终会停在   ···<target<···大于等于在右边，小于在左边，
                if (isLeft){
                    right = mid;    //mid处等于时，right移动会不会越过mid，最后会更新mid和left移动到也等于的位置，退出循环。

                }else {
                    left = mid;

                }
            }
        }
        //防止极端情况，没有进入循环，然后越界。
        if(right < 0 || right > nums.length - 1 || nums[right] != target){
            return -1;
        }else {
            return right;
        }
    }
}
