package leetcode;

//回溯 = dfs + 剪枝
//backtrack中用for遍历所有子树，二叉树可以不用for直接左右遍历，并且设置起始index，避免重复（剪枝）。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target,0,res, path, 0);
        return res;
    }


    public void backtrack(int[] nums, int target, int index, List<List<Integer>> res, List<Integer> path, int pathSum) {

        if (pathSum == target) {
            res.add(path);
            return;
        }
        if (pathSum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, target, i, res, path, pathSum);
            path.remove(path.size() - 1);
        }
    }
}
