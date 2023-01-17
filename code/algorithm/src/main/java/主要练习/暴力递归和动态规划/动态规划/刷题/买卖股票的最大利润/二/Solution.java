package 主要练习.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.二;

public class Solution {
    public int maxProfit(int[] prices) {
        return help(prices,1,0,0);
    }
    //0代表持有 1代表未持有
    public int help(int[] prices, int status, int index, int profit){
        if(index == prices.length)
            return profit;
        if(status == 0)
            return Math.max(help(prices,0,index + 1,profit),help(prices,1,index + 1,profit + prices[index]));
        else
            return Math.max(help(prices,1,index + 1,profit),help(prices,0,index + 1,profit - prices[index]));
    }
    public int helpTwo(int[] prices, int status, int index){
        if(index == prices.length)
            return 0;
        if(status == 0)
            return Math.max(helpTwo(prices,0,index + 1),helpTwo(prices,1,index + 1) + prices[index]);
        else
            return Math.max(helpTwo(prices,1,index + 1),helpTwo(prices,0,index + 1) - prices[index]);
    }
    public int dp(int[] prices){
        int[][] dp = new int[prices.length + 1][2];
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i][0] = Math.max(dp[i + 1][0],dp[i + 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i + 1][1],dp[i + 1][0] - prices[i]);
        }
        return dp[0][1];
    }
}
