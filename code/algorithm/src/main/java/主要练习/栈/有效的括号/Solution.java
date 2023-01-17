package 主要练习.栈.有效的括号;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char temp = s.charAt(i);
            if(temp == '(')
                stack.push(temp);
            else if(temp == '[')
                stack.push(temp);
            else if(temp == '{')
                stack.push(temp);
            else{
                if(temp == ')' && stack.peek() != '(')
                    return false;
                if(temp == ']' && stack.peek() != '[')
                    return false;
                if(temp == '}' && stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
