package 面试真题.字节聪明的编辑;

import java.util.Scanner;

public class Solution {
    public static String getAnswer(String s){
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < sb.length()){
            if(index + 2 < sb.length() && sb.charAt(index) == sb.charAt(index + 1) && sb.charAt(index + 1) == sb.charAt(index + 2)){
                sb.deleteCharAt(index);
                continue;
            }
            else if(index + 3 < sb.length() && sb.charAt(index) == sb.charAt(index + 1) && sb.charAt(index + 2) == sb.charAt(index + 3)){
                sb.deleteCharAt(index + 2);
                continue;
            }
            else index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < words.length; i++)
            words[i] = scanner.next();
        for(int i = 0; i < words.length; i++)
            System.out.println(getAnswer(words[i]));
    }
}
