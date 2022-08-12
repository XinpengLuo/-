package 左神.栈和队列.括号的分数;

import java.util.*;

public class Solution {
    public int scoreOfParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == '(')
                stack.push(c);
            else{
                if(stack.peek() == '('){
                    stack.pop();
                    stack.push('1');
                }
                else{
                    int temp = 0;
                    while(stack.peek() != '(')
                        temp += stack.pop() - '0';
                    stack.pop();
                    temp *= 2;
                    stack.push((char) ('0' + temp));
                }
            }
            index++;
        }
        while (!stack.isEmpty())
            res += stack.pop() - '0';
        return stack.pop() - '0';
    }

    public static void main(String[] args) {
        String s = "(()(()))";
        Solution solution = new Solution();
        System.out.println(solution.scoreOfParentheses(s));
    }
}
