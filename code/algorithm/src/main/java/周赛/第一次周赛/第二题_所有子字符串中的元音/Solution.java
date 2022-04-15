package 周赛.第一次周赛.第二题_所有子字符串中的元音;

import java.util.Arrays;

public class Solution {
    public long countVowels(String word) {
        int[] help = new int[word.length()];
        int pre = 0;
        for(int i = word.length() - 1; i >= 0; i--){
            char temp = word.charAt(i);
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
                help[i] = pre + 1;
            else
                help[i] = pre;
            pre = help[i];
        }
        long ans = 0;
//        for(int i = 0; i < word.length(); i++)
//            ans = ans + (word.length() - i) * help[i] - i * help[i];
        int preW = word.length();
        for(int i = 0; i < word.length(); i++){
            ans += preW * help[i];
            preW -= 2;
        }
        return ans;
    }
    public long dp(String word){
        long[] dp = new long[word.length() + 1];
        long ans = 0;
        for(int i = dp.length - 2; i >= 0; i--){
            if(isValid(word.charAt(i))){
                dp[i] += dp[i + 1] + (word.length() - i);
            }
            else
                dp[i] = dp[i + 1];
            ans += dp[i];
        }
        return ans;
    }
    public boolean isValid(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowels("noosabasboosabceaa"));
    }
}
