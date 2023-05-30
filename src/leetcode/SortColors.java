package leetcode;

public class SortColors {
        public void sortColors(int[] nums) {
            int low = 0;
            int high = nums.length-1;
            quickSort(nums,low,high);
        }

        public void  quickSort(int[] nums,int low,int high){

            if(low<high){
                int pivot = patition(nums,low,high);
                quickSort(nums,low,pivot-1);
                quickSort(nums,pivot+1,high);
            }
        }

        public int patition(int[] nums,int low,int high){
            //int pivot = low;
            int pivot_num = nums[low];
            //存下pivot对应的数值，随着low移动，nums[pivot]不变，但nums[low] = 会覆盖nums[pivot]

            while (low<high){
                while (low<high && pivot_num<=nums[high]){
                    //等于的放后面，逻辑要相同，则后面while没等号，if处有等号。
                    high = high-1;
                }
                if(low<high && pivot_num>nums[high]){
                    nums[low] = nums[high];  //nums[pivot]=nums[low] 即poivot下标失效。
                    low = low + 1;
                }
                while (low<high && pivot_num>nums[low]){
                    low = low+1;
                }
                if(low<high && pivot_num<=nums[low]){
                    nums[high] = nums[low];
                    high = high - 1;
                }
            }
            nums[low] = pivot_num;
            return low;
            //pivot早已失效，循环结束时low=high=pivot应该在的位置
        }

}
