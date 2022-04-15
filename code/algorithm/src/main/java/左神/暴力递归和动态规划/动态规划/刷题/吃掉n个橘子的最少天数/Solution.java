package 左神.暴力递归和动态规划.动态规划.刷题.吃掉n个橘子的最少天数;

public class Solution {
    public int minDays(int n) {
        if(n == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        res = Math.min(res, minDays(n - 1));
        if(n % 2 == 0)
            res = Math.min(res,minDays(n / 2));
        if(n % 3 == 0)
            res = Math.min(minDays(n - 2 * (n / 3)), res);
        return res + 1;
    }
    public int dp(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            int res = Integer.MAX_VALUE;
            res = Math.min(res,dp[i - 1]);
            if(i % 2 == 0)
                res = Math.min(res,dp[i / 2]);
            if(i % 3 == 0)
                res = Math.min(res,dp[i - 2 * (i / 3)]);

            dp[i] = res + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDays(100));
        System.out.println(solution.dp(100));
    }
}
