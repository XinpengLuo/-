package 主要练习.字符串.不同的子序列;

public class Solution {
    public int numDistinct(String s, String t) {
        return help(s,t,0,0);
    }
    public int help(String s, String t, int index1, int index2){
        if(index1 == s.length() || index2 == t.length()){
            if(index2 == t.length())
                return 1;
            return 0;
        }
        int res = 0;
        if(s.charAt(index1) == t.charAt(index2))
            res += help(s,t,index1 + 1,index2 + 1);
        res += help(s,t,index1 + 1,index2);
        return res;
    }
    public int dp(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][t.length()] = 1;
        for(int i = dp.length - 1; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                int res = 0;
                if(s.charAt(i) == t.charAt(j))
                    res += dp[i + 1][j + 1];
                res += dp[i + 1][j];
                dp[i][j] = res;
            }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babgbag";
        String t = "bag";
        System.out.println(solution.numDistinct(s, t));
    }
}
