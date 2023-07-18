package leetcode;

//dp
//依靠边长的三种公式得到状态转移方程
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if (i == 0 || j==0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]) + 1;

                }

                if (dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }

        return max*max;
    }
}
