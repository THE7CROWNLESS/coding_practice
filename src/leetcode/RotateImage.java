package leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {   //是否+1，偶数都会落在右侧，而奇数则会落在中位数上(+1)和前一个(不+1)
            for (int j = 0; j < n / 2; j++) {     //因此偶数可以小于中位数的去处理1/4，奇数则1/4的上半部分要到中位数，下半部分则不动中位数。避免重复移动
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - j + 1][i];
                    matrix[n - j + 1][i] = matrix[n - i + 1][n - j + 1];
                    matrix[n - i + 1][n - j + 1] = matrix[j][n - i + 1];
                    matrix[j][n - i + 1] = tmp;
            }
        }
    }
}
