package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        //boolean[] hash = new boolean[nums.length];
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], 1); //1表示存在  且表示往后能多长
            //hash[nums[i]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = 1000000001;
            int tmp = nums[i];
            int old = 0;
            int count = 1;
            while (hash.containsKey(tmp + 1) &&  hash.get(tmp + 1) > 0){
                    old = tmp + 1;
                    count = count + hash.get(old);
                    tmp = tmp + hash.get(old);
                    hash.put(old, 0);
            }
            if(count > 1){
                hash.put(nums[i], count);
            }
            if(res < count){
                res = count;
            }
        }
        return res;
    }
}
