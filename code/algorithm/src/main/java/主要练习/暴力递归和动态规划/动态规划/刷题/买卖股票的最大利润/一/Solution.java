package 主要练习.暴力递归和动态规划.动态规划.刷题.买卖股票的最大利润.一;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,findMax(prices,i,prices[i]) - prices[i]);
        }
        return max;
    }
    public int findMax(int[] prices, int index, int target){
        int max = target;
        for(int i = index; i < prices.length; i++)
                max = Math.max(prices[i],max);
        return max;
    }
    public int dp(int[] prices){
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue,prices[i]);
            maxProfit =Math.max(prices[i] - minValue,maxProfit);
        }
        return maxProfit;
    }
}
