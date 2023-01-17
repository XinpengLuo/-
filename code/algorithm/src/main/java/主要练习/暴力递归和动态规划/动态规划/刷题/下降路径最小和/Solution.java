package 主要练习.暴力递归和动态规划.动态规划.刷题.下降路径最小和;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++)
            res = Math.min(res,help(matrix,0,i));
        return res;
    }
    public int help(int[][] matrix, int rowIndex, int colIndex){
        if(rowIndex >= matrix.length)
            return 0;
        int res = Integer.MAX_VALUE;
        res = Math.min(res,matrix[rowIndex][colIndex] + help(matrix,rowIndex + 1,colIndex));
        if(colIndex + 1 < matrix[0].length)
            res = Math.min(res,matrix[rowIndex][colIndex] + help(matrix,rowIndex + 1,colIndex + 1));
        if(colIndex - 1 >= 0)
            res = Math.min(res,matrix[rowIndex][colIndex] + help(matrix,rowIndex + 1,colIndex - 1));
        return res;
    }
    public int dp(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = 0; j < dp[i].length; j++){
                int res = Integer.MAX_VALUE;
                res = Math.min(res,matrix[i][j] + getValue(dp, i + 1,j));
                if(j + 1 < matrix[0].length)
                    res = Math.min(res,matrix[i][j] + getValue(dp,i + 1,j + 1));
                if(j - 1 >= 0)
                    res = Math.min(res,matrix[i][j] + getValue(dp,i + 1, j - 1));
                dp[i][j] = res;
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            ans = Math.min(ans,dp[0][i]);
        }
        return ans;
    }
    public int getValue(int[][] dp, int i, int j){
        if(i >= dp.length)
            return 0;
        else
            return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(solution.dp(arr));
    }
}
