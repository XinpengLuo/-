package 左神.位运算.十进制转n进制;

import java.util.*;

public class Solution {
    public static String convert(int number, int system) {
        Stack<Integer> stack = new Stack<Integer>();

        while (number > 0) {
            stack.add(number % system);
            number /= system;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public boolean isStrictlyPalindromic(int n) {
         for(int i = 2; i <= n - 2; i++){
             String convert = convert(n, i);
             System.out.println(convert);
             if(!check(convert))
                 return false;
         }
         return true;
    }
    public boolean check(String s){
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStrictlyPalindromic(4));
    }
}
