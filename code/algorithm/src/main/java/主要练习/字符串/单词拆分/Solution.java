package 主要练习.字符串.单词拆分;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return help(s,wordDict,0);
    }
    public boolean help(String target, List<String> wordDict, int index){
        if(index >= target.length())
            return true;
        boolean flag = false;
        for(int i = index; i < target.length(); i++)
            if(wordDict.contains(target.substring(index,i + 1)))
                {
                    flag = flag || help(target,wordDict,i + 1);
                }
        return flag;
    }

    public boolean dp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i = dp.length - 2; i >= 0; i--){
            boolean flag = false;
            for(int j = i; j < s.length(); j++){
                if(wordDict.contains(s.substring(i,j + 1))){
                    flag = flag || dp[j + 1];
                }
            }
            dp[i] = flag;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordList = new ArrayList<>();
        wordList.add("leet");
        wordList.add("code");
        System.out.println(solution.wordBreak(s,wordList));
        System.out.println(solution.dp(s,wordList));
    }
}
