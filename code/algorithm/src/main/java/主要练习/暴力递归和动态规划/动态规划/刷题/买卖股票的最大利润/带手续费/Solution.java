package 主要练习.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.带手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        return help(prices,fee,0,0);
    }
    public int help(int[] prices, int fee, int index, int status){
        if(index == prices.length)
            return 0;
        //1 代表持有
        if(status == 1)
            return Math.max(help(prices,fee,index + 1,1),help(prices,fee,index + 1,0) + prices[index] - fee);
        else
            return Math.max(help(prices,fee,index + 1,0),help(prices,fee,index + 1,1) - prices[index]);
    }
    public int dp(int[] prices, int fee){
        int[][] dp = new int[prices.length + 1][2];
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i][1] = Math.max(dp[i + 1][1],dp[i + 1][0] + prices[i] - fee);
            dp[i][0] = Math.max(dp[i + 1][0],dp[i + 1][1] - prices[i]);
        }
        return dp[0][0];
    }
}
