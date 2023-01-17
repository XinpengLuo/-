package 主要练习.字符串.向字符串添加空格;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] res = new char[s.length() + spaces.length];
        int left = 0;
        int right = 0;
        for(int i = 0; i < res.length; i++){
            if(right < spaces.length && left == spaces[right]){
                res[i] = ' ';
                right++;
            }
            else{
                res[i] = s.charAt(left);
                left++;
            }
        }
        return String.valueOf(res);
    }
}
