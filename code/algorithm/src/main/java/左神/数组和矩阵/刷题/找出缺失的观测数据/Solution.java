package 左神.数组和矩阵.刷题.找出缺失的观测数据;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
interface test{
    void no();
}

public class Solution{
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int total = (rolls.length + n) * mean;
        int tempSum = 0;
        for (int roll : rolls) {
            tempSum += roll;
        }
        if((total - tempSum) > 6 * n)
            return new int[]{};
        total -= tempSum;
        int val = total / n;
        int reminder = total % n;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = val + (i < reminder ? 1 : 0);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        Integer a = 1222;
        int b = 1222;
        System.out.println(a == b);
    }
}
