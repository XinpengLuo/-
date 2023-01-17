package 面试真题.乘法;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args){
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        x.add(1);
        x.add(3);
        x.add(10);
        x.add(8);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        System.out.println(minFuel(x, y));
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.next();
//        String b = scanner.next();
//        if(a.length() < b.length()){
//            String temp = a;
//            a = b;
//            b = temp;
//        }
//        int j = b.length() - 1;
//        long res = 0;
//        long carry = 1;
//        while(j >= 0){
//            long sum = 0;
//            int c = 1 , mod = 0;
//            for(int i = a.length() - 1; i >= 0; i--){
//                int temp = (b.charAt(j) - '0') * (a.charAt(i) - '0') + mod;
//                sum += (long) (temp % 10) * c;
//                mod = temp / 10;
//                c *= 10;
//            }
//            if(mod != 0)
//                sum += (long) c * mod;
//            res += sum * carry;
//            carry *= 10;
//            j--;
//        }
//        System.out.println(res);
    }
    public static long minFuel(List<Integer> x, List<Integer> y) {
        // Write your code here
        Collections.sort(x);
        Collections.sort(y);
        long res = 0;
        int targetXIndex = x.size() / 2;
        int targetX = x.get(targetXIndex), targetY = y.get(y.size() / 2);
        for(int i = 0; i < x.size(); i++){
            res += Math.abs(y.get(i) - targetY);
            if(i == targetXIndex)
                continue;
            long target = Math.abs(i - targetXIndex);
            if(i < targetXIndex)
                target = targetX - target;
            else
                target = targetX + target;
            res += Math.abs(x.get(i) - target);
        }
        return res;
    }

}

