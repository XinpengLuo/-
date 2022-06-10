package 左神.暴力递归和动态规划.动态规划.刷题.最小化目标值与所选元素的差;

public class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        return dfs(mat,0,0,target);
    }
    public int dfs(int[][] mat, int index, int sum, int target){
        if(index == mat.length)
            return Math.abs(sum - target);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < mat[index].length; i++)
            res = Math.min(res,dfs(mat, index + 1, sum + mat[index][i],target));
        return res;
    }
    public int dp(int[][] mat, int target){
        int[][] dp = new int[mat.length + 1][4901];
        for(int i = 0; i < dp[mat.length].length; i++)
            dp[mat.length][i] = Math.abs(i - target);
        for(int index = dp.length - 2; index >= 0; index--){
            for(int j = 0; j < dp[index].length; j++){
                int res = Integer.MAX_VALUE;
                for(int i = 0;i < mat[index].length; i++)
                    res = Math.min(res, j + mat[index][i] > 4900 ? Integer.MAX_VALUE : dp[index + 1][j + mat[index][i]]);
                dp[index][j] = res;
            }

        }
        return dp[0][0];
    }
}
