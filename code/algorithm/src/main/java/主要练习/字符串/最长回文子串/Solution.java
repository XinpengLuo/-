package 主要练习.字符串.最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        String res = String.valueOf(s.charAt(0));
        for(int i = 0; i < s.length() * 2 - 1; i++){
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left > res.length())
                    res = s.substring(left,right + 1);
                left--;
                right++;
            }
        }
        return res;
    }
    int max = 1;
    int start = 0;
    public String best(String s){
        for(int i = 0; i < s.length(); i++){
            help(s,i,i);
            help(s,i, i + 1);
        }
        return s.substring(start, start + max);
    }
    public void help(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        int len = j - i - 1;
        if(len > max){
            max = len;
            start = i + 1;
        }
    }
    public String dp(String s){
      if(s.length() < 2)
          return s;
      int max = 1;
      int start = 0;
      boolean[][] dp = new boolean[s.length()][s.length()];
      for(int i = 1; i < s.length(); i++)
          for(int j = 0; j <= i; j++){
              if(s.charAt(i) != s.charAt(j))
                  continue;
              if(i - j <= 2)
                  dp[j][i] = true;
              else
                  dp[j][i] = dp[j + 1][i - 1];
              if(dp[j][i] && (i - j + 1) > max){
                  max = i - j + 1;
                  start = j;
              }
          }
      return s.substring(start, start + max);
    }
}
