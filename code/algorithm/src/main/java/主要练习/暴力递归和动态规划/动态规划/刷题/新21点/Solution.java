package 主要练习.暴力递归和动态规划.动态规划.刷题.新21点;

public class Solution {
    public double new21Game(int n, int k, int maxPts) {
        return help(n, k, maxPts, 0);
    }
    public double help(int n, int k, int maxPts, int temp){
        if(temp >= k){
            if(temp <= n)
                return 1;
            return 0;
        }
        double res = 0;
        for(int i = 1; i <= maxPts; i++)
            res += help(n,k,maxPts,temp + i);
        return  res / maxPts;
    }
    public double dp(int n, int k, int maxPts){
        double[] dp = new double[k + 1];
        if(dp.length - 1 <= n)
            dp[dp.length - 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 1; j <= maxPts; j++){
                if(i + j >= dp.length){
                    if(i + j <= n)
                        dp[i] += 1;
                }
                else
                    dp[i] += dp[i + j];
            }
            dp[i] /= maxPts;
        }
        return dp[0];
    }
    public double dpBetter(int n, int k, int maxPts){
        double[] dp = new double[k + maxPts];
        double window = 0;
        for(int i = dp.length - 1; i >= 0; i--){
            if(i >= k){
                if(i <= n)
                    dp[i] = 1;
                window += dp[i];
            }
            else{
                dp[i] = window / maxPts;
                window = window + dp[i] - dp[i + maxPts];
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dp(8324,2763,6645));
        System.out.println(solution.dpBetter(8324,2763,6645));
    }
}
