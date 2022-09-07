package 左神.暴力递归和动态规划.递归和回溯.刷题.判断一个括号字符串是否有效;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        return dfs(s,0,0,locked);
    }
    public boolean dfs(String s, int index, int temp, String locked){
        if(index == s.length())
            return temp == 0;
        boolean res = false;
        char c = s.charAt(index);
        if(c == '(')
            temp++;
        else
            temp--;
        if(temp >= 0) {
            res = dfs(s, index + 1, temp, locked) || res;
            if(locked.charAt(index) == '0')
                res = dfs(s, index + 1, temp - 2, locked) || res;
        }
        if(temp < 0){
            if(locked.charAt(index) == '1')
                return false;
            temp = 1;
            res = res || dfs(s,index + 1,temp,locked);
        }
        return res;
    }
}
