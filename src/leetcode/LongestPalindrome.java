package leetcode;
//暴力解法：两层循环遍历全部子串，再一层循环判断子串是否为回文串。
//动态规划：两层循环遍历全部字串，同时用dp[][]记录，只需要之前的dp记录和当前[i]和[j]是否相等，就能判断子串是否为回文。
//中心扩散：通过中心和两端来遍历子串（而不是头尾，也非全部子串），同时两端是否相等即可判断子串是否为回文，不相等直接结束，减少子串遍历。
//利用回文的特点，在遍历时判断当前是否相等，解决判断是否为回文。
public class LongestPalindrome {
    public String longestPalindrome_dp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int subLen = 1; subLen <= len; subLen++) {
            for (int i = 0; i < len; i++) {
                int j = i + subLen - 1;
                if(j < len){
                    if(subLen == 1){
                        dp[i][j] = true;
                    }else if(subLen == 2){
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    }else {
                        dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    }
                }else{
                    break;
                }
            }
        }
        int subLen = 0;
        int index_i = 0;
        int index_j = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(dp[i][j] && subLen < j -i + 1){
                    subLen = j - i + 1;
                    index_i = i;
                    index_j = j + 1;
                }else {
                    continue;
                }
            }
        }

        return s.substring(index_i, index_j);
    }

    public String longestPalindrome_centerDiffusion(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] chars = s.toCharArray();
        int begin = 0;
        int subLen = 0;
        for (int center = 0; center < len; center++) {
                left = center - 1;
                right = center + 1;
            while (left >= 0 && right <= len -1  && chars[left] == chars[right]){
                left--;
                right++;
            }
            if(subLen < right - left - 1){
                subLen = right - left - 1;
                begin = left + 1;
            }
            if(center < len - 1 && chars[center] == chars[center + 1]){
                left = center - 1 ;
                right = center + 2 ;
                while (left >= 0 && right <= len -1  && chars[left] == chars[right]){
                    left--;
                    right++;
                }
                if(subLen < right - left - 1){
                    subLen = right - left - 1;
                    begin = left + 1;
                }
            }

        }
        return  s.substring(begin, begin + subLen);
    }

}
