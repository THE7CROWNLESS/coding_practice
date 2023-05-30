package leetcode;

//荷兰国旗问题也可以解决排序问题，不断地分两段。尤其当排序个数小的时候-->分块，再利用双指针，再次减少遍历次数。
public class HelanFlag {
    //V1版本：分块，类似快排思想
    //左边都小于target，右边大于target，但两边其他数字是无序的。
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
    //V2版本：分三块，
    //左边小，右边大，中间等于。
    //在数组内容特殊时，可以达到O(n)的排序复杂度。
    public void helanFlagV2(int[] nums,int target){
        int left = -1;
        int i = 0;
        int tmp = 0;
        int right = nums.length;
        for(i=0; i<right; i++){  //i不能超过左右括号
            if(nums[i]<target){
                left = left+1;
                tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
            }else if (nums[i]>target){
                right = right-1;
                tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                i = i-1;
            }else {
                continue;
            }
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
    }

}
