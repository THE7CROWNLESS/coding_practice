package leetcode;

public class MaxSubArray {
    public int maxSubArray_dp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }




}
