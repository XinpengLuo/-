package 面试真题.华为机试.走方格的方案数;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt() + 1;
            int m = scanner.nextInt() + 1;
            System.out.println(dp(m,n));
        }
    }
    public static int getAnswer(int m, int n, int i, int j){
        if(i >= m || j >= n)
            return 0;
        if(i == m - 1 && j == n - 1)
            return 1;
        return getAnswer(m,n,i + 1,j) + getAnswer(m,n,i,j + 1);
    }
    public static int dp(int m, int n){
       int[][] dp = new int[m][n];
       dp[m - 1][n - 1] = 1;
       for(int i = 0; i < n; i++)
           dp[m - 1][n - 1] = 1;
       for(int i = 0; i < m; i++)
           dp[i][i] = 1;
       for(int i = dp.length - 2; i >= 0; i--)
           for(int j = dp[i].length - 2; j >= 0; j--)
               dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
       return dp[0][0];
    }
}
