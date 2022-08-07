package 左神.暴力递归和动态规划.动态规划.刷题.两个字符串的最小ASCII删除和;

public class Solution {

    public int help(String s1, String s2, int index1, int index2){
        if(index1 == s1.length() || index2 == s2.length())
            return 0;
        if(s1.charAt(index1) == s2.charAt(index2))
            return 1 + help(s1,s2,index1 + 1,index2 + 1);
        return Math.max(help(s1,s2,index1 + 1,index2),help(s1, s2, index1, index2 + 1));
    }
    public int dp(String s1,String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = s1.length() - 1; i >= 0; i--)
            for(int j = s2.length() - 1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
                else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        return dp[0][0];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int sum = 0, index = 0;
        while (index < s1.length() || index < s2.length()){
            int a = index == s1.length() ? 0 : s1.charAt(index);
            int b = index == s2.length() ? 0 : s2.charAt(index);
            sum += (a + b);
            index++;
        }
        int target = dp(s1,s2) * 2;
        return sum - target;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeleteSum("delete", "eat"));
    }

}
