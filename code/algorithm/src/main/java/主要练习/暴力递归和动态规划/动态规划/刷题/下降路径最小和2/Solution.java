package 主要练习.暴力递归和动态规划.动态规划.刷题.下降路径最小和2;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] arr) {
        return help(arr,0,-1);
    }
    public int help(int[][] arr, int index, int preCol){
        if(index == arr.length)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < arr[index].length; i++)
            if(i != preCol)
                res = Math.min(res,arr[index][i] + help(arr,index + 1,i));
        return res;
    }
    public int dp(int[][] arr){
        int m = arr.length, n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++)
            dp[m - 1][i] = arr[m - 1][i];
        for(int i = m - 2; i >= 0; i--)
            for(int j = 0; j < n; j++){
                int res = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++)
                    if(k != j)
                        res = Math.min(res,dp[i + 1][k]);
                dp[i][j] = arr[i][j] + res;
            }
        int ans = Integer.MAX_VALUE;
        for (int i : dp[0]) {
            ans = Math.min(ans,i);
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solution.dp(arr));
    }
}
