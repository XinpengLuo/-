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
        boolean flag = false;
        int a = targetIndex;
        for(int i = index1; i < s1.length(); i++){
            if(s1.charAt(i) == s3.charAt(a)){
                flag = flag || help(s1,s2,s3,i + 1,index2);
                a++;
            }
            else
                break;
        }
        int b = targetIndex;
        for(int i = index2; i < s2.length(); i++){
            if(s2.charAt(i) == s3.charAt(b)){
                flag = flag || help(s1,s2,s3,index1,i + 1);
                b++;
            }
            else
                break;
        }
        return flag;
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
    public boolean helpS1(String s1, String s2, String s3, int index1, int targetIndex, int index2){
        if(targetIndex >= s3.length())
            return true;
        boolean flag = false;
        for(int i = index1; i < s1.length(); i++){
            if(s1.charAt(i) == s3.charAt(targetIndex))
                {
                    flag = flag || helpS2(s1,s2,s3,i + 1,targetIndex + 1,index2);
                    targetIndex++;
                }
            else
                break;
        }
        return flag;
    }
    public boolean helpS2(String s1, String s2, String s3, int index1, int targetIndex, int index2){
        if(targetIndex >= s3.length())
            return true;
        boolean flag = false;
        for(int i = index2; i < s2.length(); i++){
            if(s2.charAt(i) == s3.charAt(targetIndex)){
                flag = flag || helpS1(s1,s2,s3,index1,targetIndex + 1,i + 1);
                targetIndex++;
            }
            else
                break;
        }
        return flag;
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
