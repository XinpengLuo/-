package 面试真题.招银激励值;

public class Main {
    public int findMaxValue(int[][] projects){
        int n = projects.length, m = projects[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = projects[n - 1][m - 1];
        for(int j = m - 2; j >= 0; j--)
            dp[n - 1][j] = projects[n - 1][j] + dp[n - 1][j + 1];
        for(int i = n - 2; i >= 0; i--)
            dp[i][m - 1] = projects[i][m - 1] + dp[i + 1][m - 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--)
                dp[i][j] = projects[i][j] + Math.max(dp[i + 1][j],dp[i][j + 1]);
        return dp[0][0];
    }
}
