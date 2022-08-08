package 左神.数组和矩阵.刷题.数组的最小偏移量;

import java.util.*;
class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 != 0) {
                num *= 2;
            }
            pq.offer(num);
            minNum = Math.min(minNum, num);
        }
        int minDeviation = pq.peek() - minNum;
        while (pq.peek() % 2 == 0) {
            int num = pq.poll() / 2;
            pq.offer(num);
            minNum = Math.min(minNum, num);
            minDeviation = Math.min(minDeviation, pq.peek() - minNum);
        }
        return minDeviation;
    }
}
