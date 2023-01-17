package 主要练习.数组和矩阵.刷题.重排数字的最小值;

import java.util.Arrays;

public class Solution {
    public long smallestNumber(long num) {
        if(num == 0)
            return 0;
        if(num < 0){
            String str = String.valueOf(num);
            char[] chars = str.substring(1, str.length()).toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder(String.valueOf(chars));
            String temp = sb.reverse().toString();
            long res = Long.parseLong(temp);
            return -res;
        }
        else{
            char[] str = String.valueOf(num).toCharArray();
            Arrays.sort(str);
            int index = 0;
            while (str[index] == '0')
                index++;
            if(index != 0){
                char temp = str[0];
                str[0] = str[index];
                str[index] = temp;
            }
            return Long.parseLong(String.valueOf(str));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long test = 310;
        System.out.println(solution.smallestNumber(test));
    }
}
