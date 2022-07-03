package 左神.暴力递归和动态规划.动态规划.刷题;

import java.net.ServerSocket;
import java.util.Arrays;

public class Solution {
    //求左上角到右下角有多少种路径
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //每一个元素 代表有多少种路径
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        return dp[m - 1][n - 1];
    }

    //求左下角到右下角的最小路径和
    public int getMinPath(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length]; //每一个元素代表走到当前节点的最小路径和
        dp[0][0] = grid[0][0];
        for(int i = 1; i < dp.length; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for(int i = 1; i < dp[0].length; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        for(int i = 1; i < dp.length; i++)
            for(int j = 1; j < dp[0].length; j++)
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
        return dp[dp.length - 1][dp[0].length - 1];
    }
    //目标和
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2,3},{4,5,6}};
        System.out.println(solution.getMinPath(arr));
    }
}
class A{
    public A(){
        System.out.println("aaaaa");
    }
}
class Test{
    static int a;
    static A aa = new A();
    public Test(){
        System.out.println("chu");
    }

    public static void main(String[] args) {
        System.out.println(Test.a);
        Test.a = 1;
        System.out.println(Test.a);
    }
}