package leetcode;

//深度优先遍历
//递归
public class NumOfIslands {


    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j] && isIsland(i,j,grid,visited)){
                    num++;
                }
            }
        }
        return num;
    }


    public boolean isIsland(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return true;
        }
        if (grid[i][j] == '0' || visited[i][j]) {
            return true;
        }

        if (grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;

            return (isIsland(i + 1, j, grid, visited) && isIsland(i - 1, j, grid, visited)
                    && isIsland(i, j + 1, grid, visited) && isIsland(i, j - 1, grid, visited));
        }
        return false;
    }
}
