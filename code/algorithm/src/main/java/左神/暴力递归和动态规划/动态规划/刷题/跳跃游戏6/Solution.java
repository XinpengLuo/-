package 左神.暴力递归和动态规划.动态规划.刷题.跳跃游戏6;

import java.util.HashMap;

public class Solution {
    public int maxResult(int[] nums, int k) {
        return help(nums,k,0);
    }
    public int help(int[] nums, int k, int index)
    {
        if(index == nums.length - 1)
            return nums[index];
        int res = Integer.MIN_VALUE;
        res = Math.max(res,nums[index] + help(nums,k,index + 1));
        for(int i = 2; i <= k; i++)
            if(index + i < nums.length)
                res = Math.max(res,nums[index] + help(nums,k,index + i));
        return res;
    }
    public int dp(int[] nums, int k){
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = nums[nums.length - 1];
        int maxValueIndex = dp.length - 1;
        for(int i = dp.length - 2; i >= 0; i--){
            int res = Integer.MIN_VALUE;
            res = Math.max(res,nums[i] + dp[i + 1]);
            if(i + k < dp.length && i + k >= maxValueIndex)
                dp[i] = nums[i] + dp[maxValueIndex];
            else {for(int j = 2; j <= k; j++)
                {
                    if(i + j < dp.length)
                        res = Math.max(res,nums[i] + dp[i + j]);
                }
            dp[i] = res;}
            maxValueIndex = dp[i] > dp[maxValueIndex] ? i : maxValueIndex;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {19,-1};
        System.out.println(solution.maxResult(arr,1));
    }
}
