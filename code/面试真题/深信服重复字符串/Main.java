package 面试真题.深信服重复字符串;

import java.util.*;
public class Main{
    public static int getAnswer(String s){
        if(s.equals(""))
            return 0;
        int res = 0;
        for(int i = 1; i < s.length() / 2; i++)
        {
            int count = 0;
            for(int j = 0; j < s.length() - i; j++){
                if(s.charAt(j) == s.charAt(i + j))
                    count++;
                else
                    count = 0;
                if(count == i){
                    res = Math.max(count * 2, res);
                    count = 0;
                }
            }

        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(getAnswer(str));
    }
}