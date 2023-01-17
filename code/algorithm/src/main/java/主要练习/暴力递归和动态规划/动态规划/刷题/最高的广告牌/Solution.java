package 主要练习.暴力递归和动态规划.动态规划.刷题.最高的广告牌;

public class Solution {
    public int tallestBillboard(int[] rods) {
        return help(rods,0,0);
    }
    public int help(int[] rods, int index, int tempValue){
        if(index >= rods.length){
            if(tempValue == 0)
                return 0;
            return -5000;
        }
        return Math.max(help(rods,index + 1,tempValue),Math.max(help(rods,index + 1,tempValue + rods[index]) + rods[index],
                help(rods,index + 1,tempValue - rods[index])));
    }
    public int dp(int[] rods){
        int maxValue = 0;
        for (int rod : rods) {
            maxValue += rod;
        }
        int[][] dp = new int[rods.length + 1][maxValue * 2 + 1];
        for(int i = 0; i < dp[rods.length].length; i++)
            if(i != maxValue)
                dp[rods.length][i] = Integer.MIN_VALUE / 3;
        for(int i = dp.length - 2; i >= 0; i--) // --> index
            for(int j = 0; j < maxValue * 2 + 1; j++){
                dp[i][j] = Integer.MIN_VALUE / 3;
               dp[i][j] = Math.max(dp[i][j],dp[i + 1][j]);
               dp[i][j] = Math.max(getValue(i + 1,j + rods[i],dp) + rods[i],dp[i][j]);
               dp[i][j] = Math.max(getValue(i + 1,j - rods[i],dp),dp[i][j]);
            }

        return dp[0][maxValue];
    }
    public int getValue(int i , int j, int[][] dp){
        if(j < 0 || j >= dp[i].length)
            return Integer.MIN_VALUE / 3;
        return dp[i][j];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {61, 45, 43, 54, 40, 53, 55, 47, 51, 59, 42};
        System.out.println(solution.tallestBillboard(nums));
        System.out.println(solution.dp(nums));
    }
}
