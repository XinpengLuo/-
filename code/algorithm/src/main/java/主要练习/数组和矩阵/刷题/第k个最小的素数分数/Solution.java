package 主要练习.数组和矩阵.刷题.第k个最小的素数分数;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++)
                temp.add(new int[]{arr[i],arr[j]});
        Collections.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] * t2[1] - t1[1] * t2[0];
            }
        });
        return temp.get(k - 1);
    }
}
