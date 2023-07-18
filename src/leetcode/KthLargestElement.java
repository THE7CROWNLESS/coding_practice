package leetcode;

import java.util.Random;

//快排的思想

//循环不变量的新思想
public class KthLargestElement {
    private int k;
    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1);

    }

    private int quickSort(int[] nums, int left, int right) {
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            return nums[pivot];
        } else if (pivot > k) {
            return quickSort(nums, left, pivot - 1);
        } else {
            return quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = random.nextInt(right - left + 1) + left;
        int x = nums[pivot];
        swap(nums,pivot,right);
        //初始地方在left右侧
        int j = left-1;
        //循环不到right处，即保证不会交换导致pivot的值改变
        for (int i = left; i < right; i++) {
            if (nums[i] < x) {
                j++;
                swap(nums, j, i);
            }
        }

        //right保存的就是pivot的值
        swap(nums,j,right);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
