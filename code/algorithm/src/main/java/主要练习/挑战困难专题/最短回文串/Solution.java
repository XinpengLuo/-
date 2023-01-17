package 主要练习.挑战困难专题.最短回文串;

public class Solution {
    public String shortestPalindrome(String s) {
        int end = s.length() - 1;
        for(; end >= 0; end--){
            if(isValid(s,0,end)){
                break;
            }
        }
        String pre = s.substring(end + 1,s.length());
        return new StringBuilder(pre).reverse().toString() + s;
    }
    public String better(String s){
        String rs = new StringBuilder(s).reverse().toString();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(0,s.length() - i).equals(rs.substring(i)))
            {
                res = i;
                break;
            }
        }
        return new StringBuilder(s.substring(s.length() - res)).reverse() + s;
    }
    public boolean isValid(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
