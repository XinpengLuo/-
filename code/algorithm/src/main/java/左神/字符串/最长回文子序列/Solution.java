package 左神.字符串.最长回文子序列;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < dp.length; i++)
            dp[i][i] = 1;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = i + 1; j < dp[i].length; j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        return dp[0][n - 1];
    }
    public int longTest(String s){
        return help(s,0,s.length() - 1);
    }
    public int help(String s, int left, int right){
        if(left > right)
            return 0;
        if(left == right)
            return 1;
        if(s.charAt(left) == s.charAt(right))
            return 2 + help(s,left + 1,right - 1);
        else
            return Math.max(help(s,left,right - 1),help(s,left + 1,right));
    }

    public int dp(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[i][i] = 1;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = i + 1; j < dp.length; j++)
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
        return dp[0][n - 1];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.help("cbbd",0,3));
    }
}
