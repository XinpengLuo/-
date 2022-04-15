package 左神.暴力递归和动态规划.动态规划.刷题.分汤;

import java.awt.*;
import java.security.PublicKey;

public class Solution {
    public double soupServings(int N) {
        return dp(N,N);
    }
    public double help(double A, double B){
        A = A < 0 ? 0.0 : A;
        B = B < 0 ? 0.0 : B;
        if(A == 0.0 && B == 0.0)
            return 0.5;
        if(A == 0.0 && B != 0.0)
            return 1.0;
        if(A != 0.0 && B == 0.0)
            return 0.0;
        return 0.25 * (help(A - 4,B) + help(A - 3,B - 1) + help(A - 2, B - 2) + help(A - 1,B - 3));
    }
    public double dp(int A, int B){
        int length = (A + 25 - 1) / 25;
        System.out.println(length);
        double[][] dp = new double[length + 1][length + 1];
        for (int i = 0; i < dp[0].length; i++)
            dp[i][0] = 0.0;
        for(int i = 1; i < dp.length; i++)
            dp[0][i] = 1.0;
        dp[0][0] = 0.5;
        for(int i = 1; i < dp.length; i++)
            for(int j = 1; j < dp[i].length; j++){
                dp[i][j] = 0.25 * (getValue(dp,i - 4,j) + getValue(dp,i - 3,j - 1) + getValue(dp,i - 2,j - 2) + getValue(dp,i - 1,j - 3));
            }
        return dp[length][length];
    }
    public double getValue(double[][] dp, int i, int j){
        i = i < 0 ? 0 : i;
        j = j < 0 ? 0 : j;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(52 + 24 / 25);
        int number = 51;
        System.out.println(solution.soupServings(number));
        System.out.println(solution.help(number / 25.0, number / 25.0));
    }
}
