package 左神.字符串.回文子串;

public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length() * 2 - 1; i++){
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
