package 左神.暴力递归和动态规划.动态规划.刷题.整数替换;

class Solution {
    public int integerReplacement(int n) {
        return help(n);
    }
    public int help(int n){
        if(n == 1)
            return 0;
        if(n % 2 == 0)
            return 1 + help(n / 2);
        else
            return 1 + Math.min(help(n + 1), help(n - 1));
    }
    public int dp(int n){
        int[] dp = new int[n + 1];
        for(int i = 2; i < dp.length; i++){
            if(i % 2 == 0)
                dp[i] = 1 + dp[i / 2];
            else
                dp[i] = 1 + Math.min(dp[(n + 1) / 2],dp[n - 1]); //n + 1 替换后 就变成了偶数了
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dp(199));
    }
}