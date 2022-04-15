package 左神.暴力递归和动态规划.动态规划.刷题.出界的路径数;

public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        if(maxMove == 0)
            return 0;
        return findPaths(m,n,maxMove - 1,startRow + 1,startColumn) +
                findPaths(m,n,maxMove - 1,startRow - 1,startColumn) +
                findPaths(m,n,maxMove - 1,startRow,startColumn + 1) +
                findPaths(m,n,maxMove - 1,startRow,startColumn - 1);
    }
    public int dp(int m, int n, int maxMove, int startRow, int startColumn){
        long[][][] dp = new long[maxMove + 1][m][n];
        int MOD = 1000000007;
        for(int i = 1; i <= maxMove; i++)
            for(int j = 0; j < m; j++) //行
                for(int k = 0; k < n; k++) //列
                   { dp[i][j][k] = (getValue(dp,j + 1,k,m,n,i - 1) % MOD +
                            getValue(dp,j - 1,k,m,n,i - 1)% MOD +
                            getValue(dp,j,k + 1,m,n,i - 1) % MOD+
                            getValue(dp,j,k - 1,m,n,i - 1)% MOD) % MOD;

                   }
        return (int) dp[maxMove][startRow][startColumn];
    }
    public long getValue(long[][][] dp, int startRow, int startCol, int m, int n, int maxMove){
        if(startRow < 0 || startRow >= m || startCol < 0 || startCol >= n)
            return 1;
        if(maxMove == 0)
            return 0;
        return dp[maxMove][startRow][startCol];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dp(8, 8, 18, 4, 4));
    }
}
