package 主要练习.暴力递归和动态规划.动态规划.刷题.K个逆序对数组;

public class Solution {
    //二维数组版的动态规划 纯粹暴力 尝试转移方程
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++)
            for(int j = dp[i].length - 1; j >= 0; j--){
                for(int t = j; t >= Math.max(0,j - (i - 1)); t--)
                    dp[i][j] = (dp[i][j] + (dp[i - 1][t])) % mod;

            }
        return dp[n][k];
    }
    //二维压缩成一唯空间 时间并没有提升多少
    public int getBetter(int n, int k){
        int[] temp = new int[k + 1];
        temp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i < n + 1; i++)
        {
            int[] dp = new int[k + 1];
            for(int j = k; j >= 0; j--)
                for(int t = j; t >= Math.max(0,j - (i - 1)); t--)
                    dp[j] = (dp[j] + temp[t]) % mod;
            temp = dp;
        }
        return temp[k];
    }
    public int best(int n, int k){
        int[] temp = new int[k + 1];
        temp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i < n + 1; i++)
        {
            int[] dp = new int[k + 1];
            dp[0] = 1;
            for(int j = 1; j <= k; j++)
              {  dp[j] = ((dp[j - 1]+ temp[j]) % mod - (j - i >= 0 ? temp[j - i] : 0));
                 if(dp[j] < 0)
                     dp[j] += mod;
                 dp[j] = dp[j] % mod;
              }
            temp = dp;
        }
        return temp[k];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kInversePairs(1000, 1000));
        System.out.println(solution.best(1000,1000));
    }
}
