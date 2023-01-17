package 主要练习.暴力递归和动态规划.动态规划.刷题.猜数字2;

public class Solution {
    public int getMoneyAmount(int n) {
        return help(1,n);
    }
    public int help(int left, int right){
        if(left >= right)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = left; i < right; i++){
            int cost = i + Math.max(help(left,i - 1),help(i + 1,right));
            ans = Math.min(ans,cost);
        }
        return ans;
    }
    public int dp(int n){
        int[][] dp = new int[n + 1][n + 1];
        for(int left = dp.length - 2; left >= 1; left--)
            for(int right = left + 1; right < dp[left].length; right++){
                dp[left][right] = Integer.MAX_VALUE;
                for(int i = left; i < right; i++){
                    int cost = i + Math.max(dp[left][i - 1],dp[i + 1][right]);
                    dp[left][right] = Math.min(dp[left][right],cost);
                }
            }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMoneyAmount(4));
        System.out.println(solution.dp(4));
    }
}
