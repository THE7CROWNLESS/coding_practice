package leetcode;
//dp
//dp变种，组合dp？
//最大值：dp[i - 1] * nums[i], nums[i], dp_min[i - 1] * nums[i] 当存在负负的正时，最大值会利用最小值与当前的乘积取到该情况
//最小值：dp_min[i - 1] * nums[i], nums[i], dp[i - 1] * nums[i] 最小值的乘积，当符号变换时，最小值可以通过最大值转换符号乘积后取到

public class MaxProductArray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
//        int[] dp = new int[len];
//        int[] dp_min = new int[len];
//        dp[0] = nums[0];
//        dp_min[0] = nums[0];
        int dp_max = nums[0];
        int dp_min = nums[0];

        int max = nums[0];
        for (int i = 1; i < len; i++) {
            int tmp = dp_max; //防止dp_max在min中使用时已经被修改
            dp_max = Math.max(dp_max * nums[i], Math.max(nums[i], dp_min * nums[i]));
            dp_min = Math.min(dp_min * nums[i], Math.min(nums[i], tmp * nums[i]));
            if (max < dp_max) {
                max = dp_max;
            }
        }
        return max;
    }
}
