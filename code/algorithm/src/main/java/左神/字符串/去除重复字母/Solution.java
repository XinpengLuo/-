package 左神.字符串.去除重复字母;
import java.util.Stack;
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] flags = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if(flags[c - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peek() > c){
                if(count[stack.peek() - 'a'] == 0)
                    break;
                flags[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            flags[c - 'a'] = true;
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
