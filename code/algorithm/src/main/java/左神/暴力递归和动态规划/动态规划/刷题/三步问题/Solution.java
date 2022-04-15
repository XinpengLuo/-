package 左神.暴力递归和动态规划.动态规划.刷题.三步问题;

public class Solution {
    public int waysToStep(int n) {
        if(n <= 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;
        return waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3);
    }
    public int dp(int n){
        if(n <= 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 2; dp[2] = 4;
        for(int i = 3; i <= n; i++)
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToStep(5));
        System.out.println(solution.dp(1));
    }
}
