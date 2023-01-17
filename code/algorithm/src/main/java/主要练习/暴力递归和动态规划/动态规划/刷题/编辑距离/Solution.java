package 主要练习.暴力递归和动态规划.动态规划.刷题.编辑距离;

public class Solution {
    public int minDistance(String word1, String word2) {
        return help(word1,word2,0,0);
    }
    public int help(String word1, String word2, int index1, int index2){
        if(index1 >= word1.length() || index2 >= word2.length()){
            if(index1 == word1.length() && index2 == word2.length())
                return 0;
            return word1.length() - index1 + word2.length() - index2;
        }
        int res = Integer.MAX_VALUE;
        if(word1.charAt(index1) == word2.charAt(index2))
            return Math.min(help(word1,word2,index1 + 1, index2 + 1),res) ;
        //替换
        res = Math.min(res, 1 + help(word1,word2,index1 + 1,index2 + 1));
        //删除
        res = Math.min(res,1 + help(word1,word2,index1 + 1,index2));
        //插入
        res = Math.min(res,1 + help(word1,word2,index1,index2 + 1));
        return res;
    }
    public int dp(String word1, String word2){
        if(word1 == null || word2 == null)
            return 0;
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < word2.length(); i++)
            dp[word1.length()][i] = word2.length() - i;
        for(int i = 0; i < word1.length(); i++)
            dp[i][word2.length()] = word1.length() - i;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else{
                    int res = Integer.MAX_VALUE;
                    res = Math.min(res,dp[i + 1][j + 1]);
                    res = Math.min(res,dp[i + 1][j]);
                    res = Math.min(res,dp[i][j + 1]);
                    dp[i][j] = res + 1;
                }
            }
        return dp[0][0];
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }
}
