package 主要练习.暴力递归和动态规划.动态规划.刷题.统计放置房子的方式数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int countHousePlacements(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        int mod = 1000000007;
        long ans = 0;
        long a = 1;
        long b = 2;
        for(int i = 2; i <= n; i++){
            ans = (a + b) % mod;
            a = b;
            b = ans;
        }
        ans %= mod;
        return (int)((ans * ans) % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHousePlacements(100));
    }
}
