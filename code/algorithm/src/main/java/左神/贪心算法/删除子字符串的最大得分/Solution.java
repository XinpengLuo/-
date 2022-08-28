package 左神.贪心算法.删除子字符串的最大得分;

import java.util.*;

public class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        if(x < y){
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            index++;
            if(c == 'b'){
                if(!stack.isEmpty() && stack.peek() == 'a'){
                    stack.pop();
                    res += x;
                    continue;
                }
            }
            stack.push(c);
        }
        // b a
        Stack<Character> help = new Stack<>();
        while (!stack.isEmpty()){
            char c = stack.pop();
            if(c == 'b' && !help.isEmpty() && help.peek() == 'a'){
                help.pop();
                res += y;
            }
            else
                help.push(c);
        }
        return res;
    }
}
