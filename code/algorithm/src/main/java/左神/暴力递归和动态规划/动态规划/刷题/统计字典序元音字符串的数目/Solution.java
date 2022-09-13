package 左神.暴力递归和动态规划.动态规划.刷题.统计字典序元音字符串的数目;

public class Solution {
    public int countVowelStrings(int n) {
        // 5 4 3 2 1
        return dfs(n,0);
    }
    // 0  1 2 3 4
    public int dfs(int n, int pre){
        if(n == 0)
            return 1;
        int sum = 0;
        for(int i = pre; i < 5; i++)
            sum += dfs(n - 1,i);
        return sum;
    }
    public int dp(int n){
        int[][] dp = new int[n + 1][5];
        for(int i = 0; i < 5; i++)
            dp[0][i] = 1;
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < 5; j++){
                int sum = 0;
                for(int k = j; k < 5; k++)
                    sum += dp[i - 1][k];
                dp[i][j] = sum;
            }

        return dp[n][0];
    }
}
