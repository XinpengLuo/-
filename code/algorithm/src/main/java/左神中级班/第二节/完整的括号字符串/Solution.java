package 左神中级班.第二节.完整的括号字符串;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    //生成所有满足闭合条件的n对括号
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateHelp(n,0,0,"");
        return res;
    }
    public void generateHelp(int n, int count, int index, String temp){
        if(index == 2 * n){
            if(count == 0)
                res.add(temp);
            return;
        }
        if(count < 0)
            return;
        generateHelp(n, count + 1, index + 1, temp + "(");
        generateHelp(n, count - 1, index + 1, temp + ")");
    }

    //判断有效的括号 有*
    public boolean checkValidString(String s) {
        return checkValidStringHelp(s.toCharArray(),0,0);
    }
    public boolean checkValidStringHelp(char[] str, int index, int count){
        if(count < 0)
            return false;
        if(index == str.length){
            if(count == 0)
                return true;
            else
                return false;
        }
        if(str[index] == '(')
            return checkValidStringHelp(str,index + 1, count + 1);
        else if(str[index] == ')')
            return checkValidStringHelp(str,index + 1, count - 1);
        else
            return checkValidStringHelp(str,index + 1, count - 1) || checkValidStringHelp(str,index + 1, count + 1) ||checkValidStringHelp(str,index + 1, count);
    }
    //动态规划版本
    public boolean checkValidStringDp(char[] str){
        boolean[][] flag = new boolean[str.length + 1][str.length + 1];
        flag[str.length][0] = true;
        for(int i = str.length - 1; i >= 0; i--)
            for(int j = 0; j < flag[i].length; j++){
                if(str[i] == '(')
                    flag[i][j] = getValue(flag,i + 1, j + 1);
                if(str[i] == ')')
                    flag[i][j] = getValue(flag,i + 1, j - 1);
                if(str[i] == '*')
                    flag[i][j] = getValue(flag,i + 1, j) || getValue(flag,i + 1, j - 1) || getValue(flag,i + 1, j + 1);
            }
        return flag[0][0];
    }
    public boolean getValue(boolean[][] flag, int i, int j){
        if(j < 0 || j >= flag[0].length)
            return false;
        return flag[i][j];
    }

    //最少添加的次数



    public static void main(String[] args) {
        Solution solution = new Solution();


    }

}
