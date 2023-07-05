package leetcode;

import java.util.HashMap;
import java.util.Map;
//摩尔投票算法  a出现超过n/2
//即使所有元素都与 a 相消， a仍会剩余
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int element = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count <= 0){
                element = nums[i];
                count++;
                continue;
            }

            if (element != nums[i]){
                count--;
            }else {
                count++;
            }
        }
        return element;
    }
}


//hashmap
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (hash.containsKey(cur)){
                hash.put(cur,hash.get(cur)+1);
            }else {
                hash.put(cur,1);
            }
        }

        int count = 0;
        int max = 0;
        for (Map.Entry entry : hash.entrySet()) {
            int cur = (Integer) entry.getValue();
            if (cur > count){
                count = cur;
                max = (int) entry.getKey();
            }
        }
        return max;
    }
}
