package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, res, 0, subset);

        return  res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int index,  List<Integer> subset){
        res.add(new ArrayList(subset)); //下面错误，因为subset是个引用值，不new的话，后续改变也会影响
        if(subset.size() == nums.length){
            return;
        }
        //相当于遍历多叉树
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, res, index+1,  subset);
            subset.remove(subset.size()-1);
        }
    }




//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> subset = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            backtrack(nums, res, i, subset);
//        }
//        return  res;
//    }
//
//
//    public void backtrack(int[] nums, List<List<Integer>> res, int index, List<Integer> subset){
//        if(index == 3){
//            res.add(subset);
//            return;
//        }
//
//        //相当于遍历多叉树
//        for (int i = index; i < nums.length; i++) {
//            subset.add(nums[i]);
//            backtrack(nums, res, index+1, subset);
//            subset.remove(i-index);
//        }
//    }
}
