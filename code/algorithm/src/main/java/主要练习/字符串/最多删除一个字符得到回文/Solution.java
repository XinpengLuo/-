package 主要练习.字符串.最多删除一个字符得到回文;

public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else
                return isValid(s,i + 1,j) || isValid(s,i,j - 1);
        }
        return true;
    }
    public boolean isValid(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
