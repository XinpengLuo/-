package 左神.暴力递归和动态规划.动态规划.刷题.无重叠区间;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        return help(intervals,0,Integer.MIN_VALUE);
    }
    public int help(int[][] intervals, int index, int preVal){
        if(index == intervals.length)
            return 0;
        int left = intervals[index][0];
        int right = intervals[index][1];
        if(left >= preVal)
            return Math.min(help(intervals,index + 1,right),help(intervals,index + 1,preVal) + 1);
        return 1 + help(intervals,index + 1,preVal);
    }
    public int dp(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[intervals.length];
        for(int i = 0; i < dp.length; i++)
            {
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(intervals[j][1] <= intervals[i][0])
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                ans = Math.min(ans, intervals.length - dp[i]);
            }
        return ans;
    }
    public int greedy(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int preEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] >= preEnd){
                count++;
                preEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
