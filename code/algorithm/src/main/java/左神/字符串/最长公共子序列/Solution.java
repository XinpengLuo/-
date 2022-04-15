package 左神.字符串.最长公共子序列;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return help(text1,text2,0,0);
    }
    public int help(String text1, String text2, int index1, int index2){
        if(index1 >= text1.length() || index2 >= text2.length())
            return 0;
        else if(text1.charAt(index1) == text2.charAt(index2))
            return 1 + help(text1,text2,index1 + 1, index2 + 1);
        else
            return Math.max(help(text1,text2,index1 + 1,index2),help(text1,text2,index1,index2 + 1));
    }
    public int dp(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = text1.length() - 1; i >= 0; i--)
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
            }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
