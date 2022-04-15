package 左神.暴力递归和动态规划.动态规划.刷题.骑士拨号;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.start(5000 ));
    }
    public long start(int n){
        long res = 0;
        int mod = 1000000007;
        long[][][] dpArr = dp(4, 3, n - 1);
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 3; j++)
                    res = (res + dpArr[i][j][n - 1]) % mod;
        return  (int)res;
    }
    public long[][][] dp(int N, int M, int K){
        long[][][] dp = new long[N][M][K + 1];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                dp[i][j][0] = 1;
        for(int l = 0; l < K + 1; l++)
        {
            dp[3][0][l] = 0;
            dp[3][2][l] = 0;
        }
        int MOD = 1000000007;
        for(int k = 1; k < K + 1; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0; j < M; j++){
                    if((i == 3 && j == 0) || (i == 3 && j == 2))
                        dp[i][j][k] = 0;
                    else{
                        long a = i - 2 < 0 || j - 1 < 0 ? 0 : (long)dp[i - 2][j - 1][k - 1] % MOD;
                        long b = i - 2 < 0 || j + 1 >= M ? 0 :(long) dp[i - 2][j + 1][k - 1]% MOD;
                        long d = i + 2 >= N || j - 1 < 0 ? 0 : (long)dp[i + 2][j - 1][k - 1] % MOD;
                        long e = i + 2 >= N || j + 1 >= M ? 0 :(long)dp[i + 2][j + 1][k - 1]% MOD;
                        long f = i - 1 < 0 || j + 2 >= M ? 0 : (long)dp[i - 1][j + 2][k - 1] % MOD;
                        long g = i + 1 >= N || j + 2 >= M ? 0 :(long) dp[i + 1][j + 2][k - 1]% MOD;
                        long h = i - 1 < 0 || j - 2 < 0 ? 0 : (long)dp[i - 1][j - 2][k - 1]% MOD;
                        long m = i + 1 >= N || j - 2 < 0 ? 0 : (long)dp[i + 1][j - 2][k - 1]% MOD;
                        dp[i][j][k] = (long) (a + b + d + e + f + g + h + m) % MOD ;
                    }
                }
        return dp;
    }
    public double allSelected(int N, int M, int K, int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= M ||(r == 3 && c == 0)||( r == 3 && c == 2 ))
            return 0;
        if(K == 0){
            if((r < N && r >= 0) && (c < M && c >= 0))
                return 1;
            else
                return 0;
        }
        return  (allSelected(N,M, K - 1, r  - 2,c - 1)+
                allSelected(N,M, K - 1, r  - 2,c + 1)+
                allSelected(N,M, K - 1, r  + 2,c - 1)+
                allSelected(N,M, K - 1, r  + 2,c + 1)+
                allSelected(N,M, K - 1, r  - 1,c + 2)+
                allSelected(N,M, K - 1, r  + 1,c + 2)+
                allSelected(N,M, K - 1, r  - 1,c - 2)+
                allSelected(N,M, K - 1, r  + 1,c - 2));
    }
}
