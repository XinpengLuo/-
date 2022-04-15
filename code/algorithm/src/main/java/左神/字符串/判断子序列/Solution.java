package 左神.字符串.判断子序列;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        return help(s,t,0,0);
    }
    public boolean help(String s, String t, int index1, int index2){
        if(index1 >= s.length())
            return true;
        if(index2 >= t.length())
            return false;
        if(s.charAt(index1) == t.charAt(index2))
            return help(s,t,index1 + 1, index2 + 1);
        return help(s,t,index1,index2 + 1);
    }
    //s是不是t的子序列
    public boolean dp(String s, String t){
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= t.length(); i++)
            dp[s.length()][i] = true;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = dp[i][j + 1];
            }
        return dp[0][0];
    }
}
