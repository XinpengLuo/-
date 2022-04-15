package 左神.字符串.删除字符串中所有相邻的项;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.toCharArray().length; i++) {
            if(top >= 0 && stack.charAt(top) == S.charAt(i)){
                stack.deleteCharAt(top);
                top -= 1;
            }
            else{
                stack.append(S.charAt(i));
                top += 1;
            }
        }
        return stack.toString();
    }
    public String removeTwo(String s){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1 ) == s.charAt(i))
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            else
                stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbacd"));
    }
}
