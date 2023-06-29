package leetcode;
//dp
//dp的计数作用
public class UniqueBst {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i;++j) {
                dp[i] += dp[j]*dp[i - j - 1];
            }
        }
        return dp[n];
    }
}