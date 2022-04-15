package 左神.字符串.两个字符串的删除操作;

public class Solution {
    public int minDistance(String word1, String word2) {
        int longestPublic = getLongestSon(word1,word2,0,0);
        System.out.println(longestPublic);
        return word1.length() - longestPublic + word2.length() - longestPublic;
    }
    //先求出最长公共子序列 再删除
    public int getLongestSon(String word1,String word2,int index1, int index2){
        if(index1 >= word1.length() || index2 >= word2.length())
            return 0;
        if(word1.charAt(index1) == word2.charAt(index2))
            return 1 + getLongestSon(word1,word2,index1 + 1, index2 + 1);
        return Math.max(getLongestSon(word1,word2,index1 + 1,index2),getLongestSon(word1,word2,index1,index2 + 1));
    }
    public int getLongestSonDp(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
            }
        return word1.length() - dp[0][0] + word2.length() - dp[0][0];
    }
    public int help(String word1, String word2, int index1, int index2){
        if(index1 == word1.length() || index2 == word2.length()){
            return word1.length() - index1 + word2.length() - index2;
        }
        if(word1.charAt(index1) == word2.charAt(index2))
            return help(word1,word2,index1 + 1,index2 + 1);
        return 1 + Math.min(help(word1,word2,index1 + 1,index2),help(word1,word2,index1,index2 + 1));

    }
    public int dp(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word2.length(); i++)
            dp[dp.length - 1][i] = word2.length() - i;
        for(int i = 0; i <= word1.length(); i++)
            dp[i][word2.length()] = word1.length() - i;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j],dp[i][j + 1]);
            }
        return dp[0][0];
    }
public static void main(String[] args) {
    Solution solution = new Solution();
    String word1 = "ffsea";
    String word2 = "eat";
    System.out.println(solution.getLongestSonDp(word1, word2));
    System.out.println(solution.help(word1,word2,0,0));
    System.out.println(solution.dp(word1,word2));
}
}
