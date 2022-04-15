package 左神.暴力递归和动态规划.动态规划.刷题.做菜顺序;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return help(satisfaction,0,1);
    }
    public int help(int[] satisfaction, int numsIndex, int timeIndex){
        if(numsIndex >= satisfaction.length)
            return 0;
        return Math.max(timeIndex * satisfaction[numsIndex] + help(satisfaction,numsIndex + 1,timeIndex + 1),
                help(satisfaction,numsIndex + 1, timeIndex));
    }
    public int dp(int[] satisfaction){
        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 1];
        for(int i = dp[0].length - 2; i >= 0; i--)
            for(int j = dp.length - 1; j >= 1; j--)
                dp[i][j] = Math.max(j * satisfaction[i] + getValue(dp,i + 1,j + 1),getValue(dp,i + 1,j));
        return dp[0][1];
    }
    public int getValue(int[][] dp, int i, int j){
        if(j >= dp.length)
            return 0;
        return dp[i][j];
}
}
