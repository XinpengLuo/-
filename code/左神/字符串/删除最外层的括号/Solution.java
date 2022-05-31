package 左神.字符串.删除最外层的括号;

import java.util.Arrays;

public class Solution {
    public String removeOuterParentheses(String s) {
        int countLeft = 0;
        int countRight = 0;
        int index = 0;
        int leftStart = 0;

        StringBuilder sb = new StringBuilder(s);
        while(index < sb.length()){
            char c = sb.charAt(index);
            if(c == '(')
                countLeft++;
            else
                countRight++;
            if(countLeft == countRight){
                sb.deleteCharAt(leftStart);
                sb.deleteCharAt(index - 1);
                index -= 1;
                leftStart = index;
            }
            else
                index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses(s));
    }
}
