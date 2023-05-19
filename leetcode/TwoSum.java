package leetcode;

import java.util.HashMap;
import java.util.Map;

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
