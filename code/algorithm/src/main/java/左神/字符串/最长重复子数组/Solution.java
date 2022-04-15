package 左神.字符串.最长重复子数组;

public class Solution {
    public int findLength(int[] A, int[] B) {
        //直接动态规划吧
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[A.length][B.length];
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(A[i] == B[j])
                    dp[i][j] = getValue(dp,i - 1, j - 1) + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max,dp[i][j]);
            }
        return max;
    }
    public int getValue(int[][] dp, int i, int j){
        if(i < 0 || j < 0)
            return 0;
        return dp[i][j];
    }
}

