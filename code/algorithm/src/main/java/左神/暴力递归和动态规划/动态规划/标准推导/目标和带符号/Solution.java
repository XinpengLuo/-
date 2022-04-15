package 左神.暴力递归和动态规划.动态规划.标准推导.目标和带符号;

import java.util.Arrays;

public class Solution {
    //递归版本
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        return help(nums, S, 0, 0);
    }
    public int help(int[] nums, int target, int i,int sum){
        if(i == nums.length){
            if(sum == target)
                return 1;
            return 0;
        }
        return help(nums,target, i + 1,sum + nums[i]) + help(nums,target, i + 1, sum - nums[i]);
    }
    //动态规划
    public int DynamicPlan(int[] nums, int S){
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            maxValue = nums[i] + maxValue;
        }
        if(maxValue < S)
            return 0;
        int c = maxValue * 2 + 1;
        int r = nums.length + 1;
        int[][] dp = new int[r][c];
        dp[r - 1][S + maxValue] = 1;
        for(int i = r - 2; i >= 0; i--)
            for(int j = 0; j < c; j++){
                int a = j + nums[i] >= c ? 0 : dp[i + 1][j + nums[i]];
                int b = j - nums[i] < 0 ? 0 : dp[i + 1][j - nums[i]];
                dp[i][j] = a + b;
            }
        return dp[0][0 + maxValue];

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0};
        System.out.println(solution.DynamicPlan(arr, 0));
    }
}
