package 主要练习.暴力递归和动态规划.动态规划.刷题.最长数对链;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        return help(pairs,0,-1);
    }
    public int help(int[][] pairs, int index, int preIndex){
        if(index == pairs.length)
            return 0;
        int res = 0;
        if( preIndex == -1 || pairs[index][0] > pairs[preIndex][1])
            res = 1 + help(pairs,index + 1,index);
        return Math.max(help(pairs,index + 1,preIndex),res);
    }
    public int dp(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[][] dp = new int[pairs.length + 1][pairs.length + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++){
                int res = 0;
                if(j == 0 || pairs[i][0] > pairs[j - 1][1])
                    res = 1 + dp[i + 1][i + 1]; //注意这里 因为你j移动了 所以对应的也要移动
                res = Math.max(dp[i + 1][j],res);
                dp[i][j] = res;
            }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][0];
    }
    public int newDp(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < pairs.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[j] + 1,dp[i]) ;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] test = {{1,2},{2,3},{3,4},{4,5},{7,8}};
        Solution solution = new Solution();
        System.out.println(solution.dp(test));
        System.out.println(solution.findLongestChain(test));
    }
}
