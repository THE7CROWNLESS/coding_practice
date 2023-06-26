package leetcode;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int res = 0;

        dfs(m, n, 1, 1, res);
        return res;
    }


    public void dfs(int m, int n, int index_m, int index_n, int cnt) {
        if (index_n > n || index_m > m) {
            return;
        } else if (index_n == n || index_m == m) {
            cnt++;
            return;
        }

        dfs(m, n, index_m + 1, index_n, cnt);
        dfs(m, n, index_m, index_n + 1, cnt);
    }

    public int dp(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m- 1][n - 1];
    }
}
