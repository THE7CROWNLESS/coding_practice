package leetcode;
//完全背包问题
//dp = 记忆化搜索 ≈ 回溯 + 剪枝
//回溯的子问题，同样也是dp的子问题，可重复是递归的for循环，也是完全背包的for；
//                            若不重复则是递归中for的start，也是01背包

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Set<String> set = new HashSet(wordDict);
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                boolean check = set.contains(s.substring(j,i));
                if(dp[j] & check){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
