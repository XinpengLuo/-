package 左神.暴力递归和动态规划.动态规划.刷题.统计元音字母序列的数目;

public class Solution {
    public int countVowelPermutation(int n) {
        return help(n,5);
    }
    public int help(int n, int pre){
        if(n == 0)
            return 1;
        if(pre == 0)
            return help(n - 1,1);
        if(pre == 1)
            return help(n - 1, 0) + help(n - 1,2);
        if(pre == 2)
            return help(n - 1, 0) + help(n - 1, 1)
                    + help(n - 1, 3) + help(n - 1, 4);
        if(pre == 3)
            return help(n - 1,2) + help(n - 1,4);
        if(pre == 4)
            return help(n - 1, 0);
        int ans = 0;
        for(int i = 0; i <= 4; i++)
            ans += help(n - 1, i);
        return ans;
    }
    public int dp(int n){
        long[][] dp = new long[n + 1][6];
        int mod = 1000000007;
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 1;
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                long ans = 0;
                if(j == 0)
                    ans = dp[i - 1][1];
                else if(j == 1)
                    ans = dp[i - 1][0] + dp[i - 1][2];
                else if(j == 2)
                    ans = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
                else if(j == 3)
                    ans = dp[i - 1][2] + dp[i - 1][4];
                else if(j == 4)
                    ans = dp[i - 1][0];
                else{
                    for(int k = 0; k <= 4; k++)
                        ans += dp[i - 1][k];
                }
                dp[i][j] = ans % mod;
            }
        return (int) dp[n][5];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(4));
        System.out.println(solution.dp(4));
    }
}
