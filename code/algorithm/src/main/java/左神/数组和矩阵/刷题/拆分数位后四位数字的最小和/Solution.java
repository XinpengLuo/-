package 左神.数组和矩阵.刷题.拆分数位后四位数字的最小和;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    public int minimumSum(int num) {
        List<Integer> temp = new ArrayList<>();
        while (num != 0){
            temp.add(num % 10);
            num /= 10;
        }
        Collections.sort(temp);
        return temp.get(0) * 10 + temp.get(2) + temp.get(1) * 10 + temp.get(3);
    }
}
