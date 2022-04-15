package 左神.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.带冷冻期;

public class Solution {
    public int maxProfit(int[] prices) {
        return help(prices,0,0);
    }
    public int help(int[] prices, int index, int status){
        if(index >= prices.length)
            return 0;
        if(status == 1)
            return Math.max(help(prices,index + 1,1),help(prices,index + 2,0) + prices[index]);
        else
            return Math.max(help(prices,index + 1,0),help(prices,index + 1,1) - prices[index]);
    }
    public int dp(int[] prices){
        int[][] dp = new int[prices.length + 2][2];
        for(int i = dp.length - 3; i >= 0; i--){
            dp[i][1] = Math.max(dp[i + 1][1],dp[i + 2][0] + prices[i]);
            dp[i][0] = Math.max(dp[i + 1][0],dp[i + 1][1] - prices[i]);
        }
        return dp[0][0];
    }
}
