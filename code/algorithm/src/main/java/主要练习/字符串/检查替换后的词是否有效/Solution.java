package 主要练习.字符串.检查替换后的词是否有效;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == 'a' || temp == 'b')
                stack.push(temp);
            if(temp == 'c'){
                if(stack.isEmpty() || stack.peek() != 'b')
                    return false;
                stack.pop();
                if(stack.isEmpty() || stack.peek() != 'a')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "abcabcababcc";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
