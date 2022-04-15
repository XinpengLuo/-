package 左神.暴力递归和动态规划.动态规划.刷题.马在棋盘上的概率;

public class Solution {
    //N为棋盘的大小  N * N
    //K为只能走k步
    public double knightProbability(int N, int K, int r, int c) {
     return allSelected(N,K,r,c);
    }
    //返回落在棋盘上的方法数
    public double allSelected(int N, int K, int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= N)
            return 0;
        if(K == 0){
            if((r < N && r >= 0) && (c < N && c >= 0))
                return 1;
            else
                return 0;
        }
        return  (allSelected(N, K - 1, r  - 2,c - 1)+
                allSelected(N, K - 1, r  - 2,c + 1)+
                allSelected(N, K - 1, r  + 2,c - 1)+
                allSelected(N, K - 1, r  + 2,c + 1)+
                allSelected(N, K - 1, r  - 1,c + 2)+
                allSelected(N, K - 1, r  + 1,c + 2)+
                allSelected(N, K - 1, r  - 1,c - 2)+
                allSelected(N, K - 1, r  + 1,c - 2)) / 8;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.knightProbability(4, 4, 3, 3));
        double a = solution.dp(8, 30, 6, 4);
        System.out.println(a);
        System.out.println(solution.allSelected(3,2,0,0));
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a / b);
    }
    public double dp(int N, int K, int r, int c){
        double[][][] dp = new double[N][N][K + 1];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                dp[i][j][0] = 1;
        for(int k = 1; k < K + 1; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++){
                    double a = i - 2 < 0 || j - 1 < 0 ? 0 : dp[i - 2][j - 1][k - 1];
                    double b = i - 2 < 0 || j + 1 >= N ? 0 : dp[i - 2][j + 1][k - 1];
                    double d = i + 2 >= N || j - 1 < 0 ? 0 : dp[i + 2][j - 1][k - 1];
                    double e = i + 2 >= N || j + 1 >= N ? 0 : dp[i + 2][j + 1][k - 1];
                    double f = i - 1 < 0 || j + 2 >= N ? 0 : dp[i - 1][j + 2][k - 1];
                    double g = i + 1 >= N || j + 2 >= N ? 0 : dp[i + 1][j + 2][k - 1];
                    double h = i - 1 < 0 || j - 2 < 0 ? 0 : dp[i - 1][j - 2][k - 1];
                    double m = i + 1 >= N || j - 2 < 0 ? 0 : dp[i + 1][j - 2][k - 1];
                    dp[i][j][k] = (a + b + d + e + f + g + h + m) / 8;
                }
        return dp[r][c][K];
    }
}
