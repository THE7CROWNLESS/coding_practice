package leetcode;
//可以将各分支的分别回溯变成当前的回溯，统一操作
import java.util.HashMap;
import java.util.Map;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dfs(board,i,j,word,0,visited)){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfs(char[][] board, int i, int j, String word, int index,boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 ||i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        if (!visited[i][j]) {
            visited[i][j] = true;
            //内部循环时，都时在该路径上，即visted置为true，即可以将分别的回溯变成当前的回溯，统一操作
            a = dfs(board, i + 1, j, word, index + 1, visited);
            //单独时未将visited回false，因为在单独层的内部，它退出时要么没改，要么自己也会将自身回溯至false
            b = dfs(board, i - 1, j, word, index + 1,visited);

            c = dfs(board, i, j + 1, word, index + 1, visited);

            d = dfs(board, i, j - 1, word, index + 1, visited);
            visited[i][j] = false; //回溯，只有当上层都已退出时，才表示当前节点出发的路径都已结束，需要回溯，visited回false
        } else {
            return false;
        }

        return (a||b||c||d);
    }
}
