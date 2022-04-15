package 左神.暴力递归和动态规划.动态规划.刷题.规划兼职工作;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        for(int i = 0; i < startTime.length - 1; i++)
            for(int j = 0; j < startTime.length - i - 1; j++){
                if(startTime[j + 1] < startTime[j]){
                    swap(startTime, j + 1,j);
                    swap(endTime,j + 1,j);
                    swap(profit,j + 1,j);
                }
            }
        return help(startTime,endTime,profit,0,0);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int help(int[] startTime, int[] endTime, int[] profit, int tempTime, int index){
        if(index >= startTime.length)
            return 0;
        if(startTime[index] < tempTime)
            return help(startTime,endTime,profit,tempTime,index + 1);
        int res = 0;
        res = Math.max(res,help(startTime,endTime,profit,endTime[index],index + 1) + profit[index]);
        res = Math.max(res,help(startTime,endTime,profit,tempTime,index + 1));
        return res;
    }

    //每一项代表前i个元素的最大的利润
    public int newDp(int[] startTime, int[] endTime, int[] profit){
        int[][] time = new int[startTime.length][3];
        for (int i = 0; i < time.length; i++) {
            time[i][0] = startTime[i];
            time[i][1] = endTime[i];
            time[i][2] = profit[i];
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] dp = new int[startTime.length];
        dp[0] = time[0][2];
        for(int i = 1; i < dp.length; i++){
            dp[i] = time[i][2];
            int left = 0;
            int right = i - 1;
            while (left < right){
                int middle = (left + right + 1) / 2; //有坑
                if(time[middle][1] <= time[i][0])
                    left = middle;
                else
                    right = middle - 1;
            }
            if(time[left][1] <= time[i][0])
                dp[i] += dp[left];
            dp[i] = Math.max(dp[i],dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] startTime = {24,24,7,2,1,13,6,14,18,24};
        int[] endTime = {27,27,20,7,14,22,20,24,19,27};
        int[] profit = {6,1,4,2,3,6,5,6,9,8};
        Solution solution = new Solution();
        System.out.println(solution.newDp(startTime, endTime, profit));

    }
    public int dp(int[] startTime, int[] endTime, int[] profit){
        for(int i = 0; i < startTime.length - 1; i++)
            for(int j = 0; j < startTime.length - i - 1; j++){
                if(startTime[j + 1] < startTime[j]){
                    swap(startTime, j + 1,j);
                    swap(endTime,j + 1,j);
                    swap(profit,j + 1,j);
                }
            }
        int maxTime = 0;
        for (int i : endTime)
            maxTime = Math.max(i,maxTime);
        int[][] dp = new int[startTime.length + 1][maxTime + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < dp[i].length; j++){
                if(startTime[i] < j)
                    dp[i][j] = dp[i + 1][j];
                else{
                    int res = 0;
                    res = Math.max(res,dp[i + 1][endTime[i]] + profit[i]);
                    res = Math.max(res,dp[i + 1][j]);
                    dp[i][j] = res;
                }
            }
        return dp[0][0];
    }
}
