package 主要练习.暴力递归和动态规划.动态规划.刷题.不同路径系列.不同路径2;

public class Solution {
    public int help(int[][] arr, int i, int j){
        if(i >= arr.length || j >= arr[0].length || arr[i][j] == 1)
            return 0;
        if(i == arr.length - 1 && j == arr[0].length - 1)
            return 1;
        return help(arr, i + 1,j) + help(arr,i,j + 1);
    }
    public int dp(int[][] arr){
        if(arr[arr.length - 1][arr[0].length - 1] == 1)
            return 0;
        int[][] dp = new int[arr.length][arr[0].length];
        dp[arr.length - 1][arr[0].length - 1] = 1;
        for(int i = dp[0].length - 2; i >= 0; i--){
            if(arr[dp.length - 1][i] == 1)
                dp[dp.length - 1][i] = 0;
            else{
                dp[dp.length - 1][i] = dp[dp.length - 1][i + 1];
            }
        }
        for(int i = dp.length - 2; i >=0; i--)
            for(int j = dp[0].length - 1; j >=0; j--){
                if(arr[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    int a = j + 1 >= dp[0].length ? 0 : dp[i][j + 1];
                    dp[i][j] = dp[i + 1][j] + a;
                }
            }
        return dp[0][0];
    }
}
