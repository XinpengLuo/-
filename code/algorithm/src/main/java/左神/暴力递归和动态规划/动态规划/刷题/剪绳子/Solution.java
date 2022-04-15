package 左神.暴力递归和动态规划.动态规划.刷题.剪绳子;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int cuttingRope(int n) {
        // 特殊情况
        if(n == 2)
            return 1;
        int res = 0;
        for(int i = 2; i < n; i++){
            res = Math.max(res, Math.max(i * cuttingRope(n - i), i * (n - i)));
        }
        return res;
    }
    public int dp(int n){
        if(n <= 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < dp.length; i++){
            int maxValue = Integer.MIN_VALUE;
            for(int j = 1; j < i; j++)
                maxValue = Math.max(maxValue,Math.max(j * dp[i - j],j *(i - j)));
            dp[i] = maxValue;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(13));
        System.out.println(solution.dp(13));
    }
}
