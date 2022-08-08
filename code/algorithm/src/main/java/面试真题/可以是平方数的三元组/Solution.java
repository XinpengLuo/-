package 面试真题.可以是平方数的三元组;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        better(1000000);
//        best(1000000);
        System.out.println(judgeSquareSum(2));
    }
    public static void better(int n ){
        long target = 1;
        long left = 1, right = n;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid <= n)
            {
                target = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        long count = target;
        if(count > 2)
            System.out.println((count - 2) * (count - 1) * count / 6);
    }
    public static void best(int n){
        long count = (long) Math.sqrt(n);
        if(count > 2)
            System.out.println((count - 2) * (count - 1) * count / 6);
    }
    public static boolean judgeSquareSum(int c) {
        long target = (long) Math.sqrt(c);
        long[] temp = new long[(int) target + 1];
        for(int i = 0; i < temp.length; i++)
            temp[i] = (i) * (i);
        int left = 0, right = temp.length - 1;
        while(left <= right){
            long sum = temp[left] + temp[right];
            if(sum == c)
                return true;
            else if(sum > c)
                right--;
            else
                left++;
        }
        return false;
    }
    public static void test(int n){
        int res = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i + 1; j <= n; j++)
                for(int k = j + 1; k <= n; k++){
                    double a = Math.sqrt(i);
                    double b = Math.sqrt(j);
                    double c = Math.sqrt(k);
                    if((int)a == a && (int)b == b && (int)c == c) {
                        res++;
                    }
                }
        System.out.println(res);
    }
}
