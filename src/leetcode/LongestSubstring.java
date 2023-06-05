package leetcode;

import java.util.HashMap;
import java.util.Map;
//滑动窗口思想：left和right向前递增，类似双指针（从一头出发）。
//双指针：一端指针移动时，代表该处及之前的情况已经不会更优了（减少了遍历）；另一端移动去探寻是否存在更优。
// + hash表来判断重复 & 快速更新left位置
//-->可解决连续最长不重复问题

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int lenghth = 0;
        int size = s.length();
        int start = 0;
        Map<Character,Integer> hash = new HashMap<>();
        int tmp = 0;

        for (int i = 0; i < size; i++) {
            if(hash.containsKey(s.charAt(i)) && hash.get(s.charAt(i)) >= start){  //start记录子串的起始位置，hash表中的value小于start，则失效（即重复字符之前的字符）
                int old_i = hash.get(s.charAt(i));
                start = old_i + 1;
                tmp = i - old_i;
                hash.put(s.charAt(i), i);
            }else {
                ++tmp;
                hash.put(s.charAt(i), i);
            }
            if(tmp > lenghth){
                lenghth = tmp;
            }
        }

        return lenghth;
    }
}
