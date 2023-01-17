package 主要练习.暴力递归和动态规划.动态规划.刷题.丑数系列;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {

    public int nthUglyNumber(int n) {
        int count = 0;
        int i = 1;
        int uglyNumber = 0;
        while (count != n){
            if(isUglyNumber(i,0))
                {
                    count++;
                    uglyNumber = i;
                }
            i++;
        }
        return uglyNumber;
    }
    //判断一个数字是不是丑数
    public static boolean isUglyNumber(int n, int mod){
        if(mod != 0)
            return false;
        if(n == 1){
            return true;
        }
        return isUglyNumber(n / 2, n % 2) || isUglyNumber(n / 3, n % 3) || isUglyNumber(n / 5, n % 5);
    }
    //动态规划版本
    public int dp(int n){
        boolean[] dp = new boolean[10000000];
        dp[0] = false;
        dp[1] = true;
        int count = 1;
        int number = 1;
        if(count == n)
            return number;
        for(int i = 2; i < dp.length; i++){
            boolean a = i % 2 == 0 ? dp[i / 2] : false;
            boolean b = i % 3 == 0 ? dp[i / 3] : false;
            boolean c = i % 5 == 0 ? dp[i / 5] : false;
            if(a || b || c){
                count++;
                if(count == n){
                    number = i;
                    break;
                }
            }
            dp[i] = a || b || c;
        }
        return number;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dp(384));
    }
    public int nthUglyNumberBetter(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        priorityQueue.add(1l);
        while (n-- > 1){
            Long temp = priorityQueue.poll();
            if(set.add(temp * 2))
                priorityQueue.add(temp * 2);
            if(set.add(temp * 3))
                priorityQueue.add(temp * 3);
            if(set.add(temp * 5))
                priorityQueue.add(temp * 5);
        }
        return Math.toIntExact(priorityQueue.poll());
    }
    public int better(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for(int i = 1; i < dp.length; i++){
            int x = dp[p1] * 2;
            int y = dp[p2] * 3;
            int z = dp[p3] * 5;
            dp[i] = Math.min(x,Math.min(y,z));
            if(dp[i] == x)
                p1++;
            if(dp[i] == y)
                p2++;
            if(dp[i] == z)
                p3++;
        }
        return dp[n - 1];
    }
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;
        while (n % 2 == 0)
            n = n / 2;
        while (n % 3 == 0)
            n = n / 3;
        while (n % 5 == 0)
            n = n / 5;
        return n == 1;
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for(int i = 1; i < dp.length; i++){
            int x = a * dp[p1];
            int y = b * dp[p2];
            int z = c * dp[p3];
            dp[i] = Math.min(x,Math.min(y,z));
            if(x == dp[i])
                p1++;
            if(y == dp[i])
                p2++;
            if(z == dp[i])
                p3++;
        }
        return dp[n - 1];
    }
}
