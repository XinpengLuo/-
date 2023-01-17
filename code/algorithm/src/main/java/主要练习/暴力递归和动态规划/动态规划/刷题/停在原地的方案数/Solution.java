package 主要练习.暴力递归和动态规划.动态规划.刷题.停在原地的方案数;

public class Solution {
    public int numWays(int steps, int arrLen) {
        return help(0,steps,arrLen);
    }
    public int help(int tempIndex, int steps, int len){
        if(tempIndex < 0 || tempIndex >= len)
            return 0;
        if(steps == 0)
            return tempIndex == 0 ? 1 : 0;
        return help(tempIndex,steps - 1,len) + help(tempIndex - 1,steps - 1,len) + help(tempIndex + 1,steps - 1,len);
    }
    public int dp(int steps, int arrLen){
        int MODULO = 1000000007;
        int[][] dp = new int[steps + 1][arrLen];
        dp[0][0] = 1;
        for(int i = 1; i <= steps; i++)
            for(int j = 0; j < arrLen; j++)
                dp[i][j] = ((dp[i - 1][j] + getValue(dp,i - 1,j - 1)) % MODULO + getValue(dp,i - 1,j + 1)) % MODULO;
        return dp[steps][0];
    }
    public int dpZip(int steps, int arrLen){
        int MODULO = 1000000007;
        int[] dp = new int[arrLen];
        dp[0] = 1;
        for(int i = 1; i <= steps; i++)
            {
                int[] dpNext = new int[arrLen];
                for(int j = 0; j < arrLen; j++)
                    {
                        if(j >= 251)
                            continue;
                        dpNext[j] = ((dp[j] + getZipValue(dp,j - 1)) % MODULO + getZipValue(dp,j + 1)) % MODULO;
                    }
                dp = dpNext;
            }
        return dp[0];
    }
    public int getZipValue(int[] dp, int i){
        if(i < 0 || i >= dp.length)
            return 0;
        return dp[i];
    }
    public int getValue(int[][] dp, int i, int j){
        if(j < 0 || j >= dp[0].length)
            return 0;
        return dp[i][j];
    }
}
