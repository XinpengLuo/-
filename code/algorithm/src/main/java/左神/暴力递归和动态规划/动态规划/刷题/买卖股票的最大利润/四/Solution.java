package 左神.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.四;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        return help(prices,0,0,k);
    }
    public int help(int[] prices, int index, int status, int time){
        if(time == 0 || index == prices.length)
            return 0;
        if(status == 1) //1代表持有
            return Math.max(help(prices,index + 1,1,time),help(prices,index + 1,0,time - 1) + prices[index]);
        else
            return Math.max(help(prices,index + 1,0,time),help(prices,index + 1, 1,time) - prices[index]);
    }
    public int dp(int[] prices,int k){
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for(int i = 1; i <= k; i++){
            dp[prices.length][0][i] = 0;
            dp[prices.length][1][i] = 0;
        }
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++)
                dp[i][j][0] = 0;
        for(int i = dp.length - 2; i >= 0; i--)
        {
            for(int j = 1; j <= k; j++){
                dp[i][0][j] = Math.max(dp[i + 1][0][j],dp[i + 1][1][j] - prices[i]);
                dp[i][1][j] = Math.max(dp[i + 1][1][j],dp[i + 1][0][j - 1] + prices[i]);
            }
        }
        return dp[0][0][k];
    }
}
