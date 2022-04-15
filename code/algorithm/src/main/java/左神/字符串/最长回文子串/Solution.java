package 左神.字符串.最长回文子串;

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
}
