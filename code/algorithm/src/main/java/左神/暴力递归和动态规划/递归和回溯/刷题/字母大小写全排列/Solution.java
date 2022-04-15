package 左神.暴力递归和动态规划.递归和回溯.刷题.字母大小写全排列;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        help(S,0,"");
        return res;
    }
    public void help(String s, int index, String temp){
        if(index == s.length())
            {
                res.add(temp);
                return;
            }
        char c = s.charAt(index);
        help(s,index + 1, temp + c);
       if(c >= 'A' && c <= 'Z')
           {
               c += 32;
               help(s,index + 1, temp + c);
           }
       else if(c >= 'a' && c <= 'z')
           {
               c -= 32;
               help(s,index + 1, temp + c);
           }
    }

    public void test(String s){

    }
    public static void main(String[] args) {
        String s = "aa";
        Solution solution = new Solution();
        solution.test(s);
        System.out.println(s);
    }
}
