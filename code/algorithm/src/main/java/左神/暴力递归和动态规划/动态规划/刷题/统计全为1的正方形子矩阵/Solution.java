package 左神.暴力递归和动态规划.动态规划.刷题.统计全为1的正方形子矩阵;

public class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0)
                    continue;
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1;
                ans += dp[i][j];
            }
        return ans;
    }
}
