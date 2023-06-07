package leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = 0;
        int index_i = 0;
        int index_j = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if(s.charAt(i) == s.charAt(j)){
                    //两端相等，判断是否为回文子串
                   if(isPalindrome(s, i, j) &&  j - i + 1 > len){
                       len = j - i + 1;
                       index_i = i;
                       index_j = j;
                   }else {
                       continue;
                   }
                }else {
                    continue;
                }
            }
        }

        return s.substring(index_i, index_j+1);
    }
    public boolean isPalindrome(String s ,int i, int j){
        while (i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
