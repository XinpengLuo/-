package 左神.暴力递归和动态规划.动态规划.标准推导.股票的最大利润;

public class Solution {
    //递归版本
    public int maxProfit(int[] prices) {
        return help(prices, 0, 0);
    }
    public int help(int[] prices,int index,int preValue){
        if(index == prices.length)
            return preValue;
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            maxValue = Math.max(maxValue,prices[i] - help(prices, index + 1,prices[i]));
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(arr));
    }
}
