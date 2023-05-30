package leetcode;

import static java.lang.Math.max;

public class MaxProfit{
    //动态规划。
    //转化问题，最大两处的利润 = 前后顺序下（最大-最小） = 最小处累计到最大处变化量的和。
    //变化量和最大：max（之前变化量和最大+当前量，当前量）
    //理解：加上当前量变小说明，之前累计的最优利润，不如本次的降价，不如从本次开始购入，并且通过res保证之后利润不大时，取最大利润
    public int maxProfit1(int[] prices) {
        int res = 0;
        int len = prices.length;
        int[] change = new int [len];
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            if(i == 0){
                change[i] = 0;
                dp[i] = 0;
            }else {
                change[i] = prices[i] - prices[i-1];
                dp[i] = max(dp[i-1] + change[i],change[i]);
                dp[i] = max(dp[i] ,0);
                if(dp[i]>dp[i-1]){
                    res = dp[i];    //res处保存最大的dp[i]
                }
            }
        }
        return  res;
    }
    //贪心策略。
    //当前最优：已遍历部分最小值--到遍历处的profit（profit更新最大的一个）
    //最小值在遍历时得到min，profit在计算时更新当前最大。
    public int maxProfit2(int[] price){
        int profit = 0;
        int min = price[0];
        int tmp = 0;
        for (int i = 1; i < price.length; i++) {
            if(price[i-1] < min){
                min = price[i-1];
                }
            if(price[i] - min >= profit){
                profit = price[i] - min;
            }
        }
        return  profit;
    }
}
