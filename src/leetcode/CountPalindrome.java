package leetcode;

import sun.plugin.cache.OldCacheEntry;

public class CountPalindrome {
    public int countSubstrings(String s) {
        int count = 0;

        count = palindrome(s,true) + palindrome(s,false);
        count = count + s.length();

        return count;
    }

    public int palindrome(String s, boolean isOod){
        int count = 0;
        int left = 0;
        int right = 0;
        for (int center = 0; center < s.length(); center++) {
            if(isOod && s.charAt(center) == s.charAt(center + 1)){
                left = center - 1;
                right = center + 2;
            }else {
                left = center - 1;
                right = center + 1;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
