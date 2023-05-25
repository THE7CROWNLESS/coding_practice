package leetcode;

public class HelanFlag {
    public void helanFlagV1(int[] nums,int target){
        int left = -1;
        int i = 0;
        int tmp = 0;

        for(i=0;i<nums.length;i++){
            if(nums[i]<target){
                left = left+1;
                tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
            }else {
                continue;
            }
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
    }
    public void helanFlagV2(int[] nums,int target){
        int left = -1;
        int i = 0;
        int tmp = 0;
        int right = nums.length;
        for(i=0;i<nums.length;i++){
            if(nums[i]<target){
                left = left+1;
                tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
            }else if (nums[i]>target){
                right = right-1;

            }
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
    }

}
