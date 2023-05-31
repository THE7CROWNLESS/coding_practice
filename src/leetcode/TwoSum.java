package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
问题描述：两数之和，数组中两数和为target，返回下标，答案唯一
*/

/*
这个题目用两个for循环确实好做，但是我还是推荐用哈希。
你觉着用两个for循环简单又快速，面试官和导师觉着你根本不懂算法。
但凡工作过，都知道要想去查找某一元素是否出现过就该用哈希。
哈希常用的三种数据结构是数组、set（集合）、map（映射）。
这题目你确定好哈希的数据结构再写出来才算真正明白。
*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map hash = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++){
            if(hash.containsKey(target-nums[i])){
                return new int[] {i,(Integer)hash.get(target-nums[i])};
            }else {
                hash.put(nums[i],i);
            }


        }
        return new  int[] {};
    }
}
