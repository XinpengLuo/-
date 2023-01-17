package 主要练习.暴力递归和动态规划.动态规划.刷题.最大正方形;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    if(i - 1 < 0)
                        dp[i][j] = 1;
                    else if(j - 1 < 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        return res * res;
    }
    public int getValue(int[][] dp, int i, int j){
        if(i < 0 || i >= dp.length || j < 0 || j >= dp[0].length)
            return Integer.MAX_VALUE;
        return dp[i][j];
    }
}
