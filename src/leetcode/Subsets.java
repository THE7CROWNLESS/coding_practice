package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, res ,path, 0);



        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int index){
        res.add(new ArrayList<>(path));
        if(index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, res, path, i+1);
            path.remove(path.size() - 1);
        }
    }

}
