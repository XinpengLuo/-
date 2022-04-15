package 左神.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.三;

public class Solution {
    public int maxProfit(int[] prices) {
        return help(prices,0,0,2);
    }
    public int help(int[] prices, int index, int status, int time){
        if(time == 0 || index == prices.length)
            return 0;
        if(status == 1) //1代表持有
            return Math.max(help(prices,index + 1,1,time),help(prices,index + 1,0,time - 1) + prices[index]);
        else
            return Math.max(help(prices,index + 1,0,time),help(prices,index + 1, 1,time) - prices[index]);
    }
    public int dp(int[] prices){
        int[][][] dp = new int[prices.length + 1][2][3];
        dp[prices.length][0][1] = 0;
        dp[prices.length][0][2] = 0;
        dp[prices.length][1][1] = 0;
        dp[prices.length][1][2] = 0;
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++)
                dp[i][j][0] = 0;
        for(int i = dp.length - 2; i >= 0; i--)
        {
            dp[i][0][1] = Math.max(dp[i + 1][0][1],dp[i + 1][1][1] - prices[i]);
            dp[i][0][2] = Math.max(dp[i + 1][0][2],dp[i + 1][1][2] - prices[i]);
            dp[i][1][1] = Math.max(dp[i + 1][1][1],dp[i + 1][0][0] + prices[i]);
            dp[i][1][2] = Math.max(dp[i + 1][1][2],dp[i + 1][0][1] + prices[i]);
        }
        return dp[0][0][2];
    }
}
