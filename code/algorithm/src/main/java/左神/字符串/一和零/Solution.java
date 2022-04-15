package 左神.字符串.一和零;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return help(strs,m,n,0,m,n);
    }
    public int help(String[] strs, int m, int n, int index, int countM, int countN){
        if(index >= strs.length)
            return 0;
        if(countN > n || countM > m)
            return 0;
        String str = strs[index];
        int curM = 0, curN = 0;
        for (int i = 0; i < str.toCharArray().length; i++) {
            if(str.charAt(i) == '0')
                curM++;
            if(str.charAt(i) == '1')
                curN++;
        }
        if(countM >= curM && countN >= curN)
            return Math.max(help(strs,m,n,index + 1,countM,countN),1 + help(strs,m,n,index + 1,countM - curM,countN - curN));
        return help(strs,m,n,index + 1,countM,countN);
    }
    public int dp(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for(int i = strs.length - 1; i >= 0; i--) // --> index
            for(int j = 0; j <= m; j++)
                for(int k = 0; k <= n; k++){
                    String str = strs[i];
                    int curM = 0, curN = 0;
                    for(int o = 0; o < str.toCharArray().length; o++){
                        if(str.charAt(o) == '0')
                            curM++;
                        if(str.charAt(o) == '1')
                            curN++;
                    }
                    if(j >= curM && k >= curN)
                        dp[i][j][k] = Math.max(dp[i + 1][j][k], 1 + dp[i + 1][j - curM][k - curN]);
                    else
                        dp[i][j][k] = dp[i + 1][j][k];
                }
        return dp[0][m][n];
    }
}
