package 左神.数组和矩阵.刷题.验证回文字符串2;

public class Solution {
    public boolean validPalindrome(String s) {
        return help(s,0,s.length() - 1, false);
    }
    public boolean help(String s, int i, int j, boolean flag){
        if(i > j)
            return false;
        if(s.charAt(i) == s.charAt(j))
            return help(s,i + 1, j - 1, flag);
        if(flag)
            return false;
        return help(s, i + 1, j, true) || help(s, i, j - 1, true);
    }
}
