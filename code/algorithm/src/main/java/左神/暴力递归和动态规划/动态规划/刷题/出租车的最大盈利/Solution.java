package 左神.暴力递归和动态规划.动态规划.刷题.出租车的最大盈利;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        return help(n,rides,0);
    }
    public long help(int n, int[][] rides, int index){
        if(index >= rides[rides.length - 1][1])
            return 0;
        long res = 0;
        for(int i = 0; i < rides.length; i++)
            if(rides[i][0] >= index)
                res = Math.max(res,help(n,rides,rides[i][1]) + (rides[i][1] - rides[i][0] + rides[i][2]));
        return res;
    }
    public long dp(int n, int[][] rides){
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        long[] dp = new long[rides[rides.length - 1][1] + 1];
        for(int i = dp.length - 2; i >= 0; i--){
            long res = 0;
            for(int j = 0; j < rides.length; j++){
                if(rides[j][0] >= i)
                        res = Math.max(res,getValue(dp,rides[j][1]) + rides[j][1] - rides[j][0] + rides[j][2]);
            }
            dp[i] = res;
        }
        return dp[0];
    }
    public long getValue(long[] dp, int j){
        if(j >= dp.length)
            return 0;
        return dp[j];
    }
    public long newDp(int n, int[][] rides){
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        long[] dp = new long[rides.length];
        dp[0] = rides[0][2] + rides[0][1]- rides[0][0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = rides[i][2] + rides[i][1] - rides[i][0];
            int left = 0;
            int right = i - 1;
            while (left < right){
                int mid = (left + right + 1) / 2;
                if(rides[mid][1] <= rides[i][0])
                    left = mid;
                else
                    right = mid - 1;
            }
            if(rides[left][1] <= rides[i][0])
                dp[i] += dp[left];
            dp[i] = Math.max(dp[i - 1],dp[i]);
        }
        return dp[dp.length - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] rides = {{1,10,5000},{2,6,14},{3,6,155}};
        System.out.println(solution.maxTaxiEarnings(   11, rides));
        System.out.println(solution.dp(   11,rides));
    }
}
