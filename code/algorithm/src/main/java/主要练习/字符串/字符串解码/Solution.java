package 主要练习.字符串.字符串解码;

import java.util.*;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            StringBuilder temp = new StringBuilder();
            if(c == ']'){
                int n = 0;
                while (stack.peek() != '[')
                    temp.append(stack.pop());
                stack.pop();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    num.append(stack.pop());
                n = Integer.parseInt(num.reverse().toString());
                for(int j = 0; j < n; j++)
                    for(int k = temp.length() - 1; k >= 0; k--)
                        stack.push(temp.charAt(k));
            }
            else
                stack.push(c);
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }
}
