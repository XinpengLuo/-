package 左神.字符串.交错字符串;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
        return help(s1,s2,s3,0,0);
    }
    public boolean help(String s1, String s2, String s3, int index1, int index2){
        int targetIndex = index1 + index2;
        if(targetIndex >= s3.length())
            return true;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(targetIndex))
            if(help(s1,s2,s3,index1 + 1,index2))
                return true;
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(targetIndex))
            if(help(s1,s2,s3,index1,index2 + 1))
                return true;
        return false;
    }
    public boolean dp(String s1,String s2,String s3){
        if(s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[i].length - 1; j >= 0; j--){
                if(i + j >= s3.length())
                    {
                        dp[i][j] = true;
                        continue;
                    }
                boolean flag = false;
                int targetIndex = i + j;
                int a = targetIndex;
                for(int k = i; k < s1.length(); k++){

                    if(s1.charAt(k) == s3.charAt(a)){
                        flag = flag || ( k + 1 >= dp.length ? false : dp[k + 1][j]);
                        a++;
                    }
                    else
                        break;
                }
                int b = targetIndex;
                for(int k = j; k < s2.length(); k++){

                    if(s2.charAt(k) == s3.charAt(b)){
                        flag = flag || (k + 1 >= dp[i].length ? false : dp[i][k + 1]) ;
                        b++;
                    }
                    else
                        break;
                }
                dp[i][j] = flag;
            }
        }
        return dp[0][0];
    }

    public boolean newDp(String s1,String s2, String s3){
        if(s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;
        for(int i = dp.length - 1; i >= 0; i--)
            for(int j = dp[i].length - 1; j >= 0; j--){
                if(i != s1.length() || j != s2.length()){
                    int targetIndex = i + j;
                    if(i < s1.length() && s1.charAt(i) == s3.charAt(targetIndex))
                        dp[i][j] = dp[i][j] || dp[i + 1][j];
                    if(j < s2.length() && s2.charAt(j) == s3.charAt(targetIndex))
                        dp[i][j] = dp[i][j] || dp[i][j + 1];
                }
            }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
        System.out.println(solution.dp(s1, s2, s3));
    }
}
