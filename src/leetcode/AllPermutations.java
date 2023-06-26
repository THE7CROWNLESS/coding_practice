package leetcode;

import java.util.*;

public class AllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> path =new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        dfs(nums,0,res,path,used);

        return res;
    }
    
    public void dfs(int[] nums, int depth,List<List<Integer>> res, List<Integer> path, Set<Integer> used){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used.contains(nums[i])){
                continue;
            }else {
                used.add(nums[i]);
                path.add(nums[i]);
                dfs(nums,depth+1,res,path,used);
                //回溯，清除下一层的加入
                used.remove(path.get(path.size() - 1));
                path.remove(path.size() - 1);
            }
        }
    }
}
