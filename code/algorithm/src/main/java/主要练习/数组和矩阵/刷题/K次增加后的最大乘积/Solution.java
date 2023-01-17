package 主要练习.数组和矩阵.刷题.K次增加后的最大乘积;

import java.util.*;

public class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        while (k-- > 0){
            int temp = queue.poll();
            queue.add(temp + 1);
        }
        long res = 1;
        int mod = 1000000007;
        while (!queue.isEmpty()){
            res = ((long)(res * queue.poll())) % mod;
        }
        return (int)res;
    }
}
