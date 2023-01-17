package 主要练习.数组和矩阵.刷题.分数到小数;

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if(a % b == 0)
            return String.valueOf(a / b);
        StringBuilder res = new StringBuilder();
        if(a * b < 0)
            res.append("-");
        a = Math.abs(a);
        b = Math.abs(b);
        res.append(a / b);
        a = a % b;
        HashMap<Long,Integer> hashMap = new HashMap<>();
        while (a != 0){
            hashMap.put(a,res.length());
            a = a * 10;
            res.append(a / b);
            a = a % b;
            if(hashMap.containsKey(a)){
                return String.format("%s(%s)", res.substring(0, hashMap.get(a)), res.substring(hashMap.get(a)));
            }
        }
        return res.toString();
    }
}
