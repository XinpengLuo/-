package 主要练习.暴力递归和动态规划.动态规划.刷题.递增的三元子序列;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            if(dp[i] == 3)
                return true;
        }
        return false;
    }
    public boolean better(int[] nums){
        if(nums.length < 3)
            return false;
        int min = nums[0];
        int max = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++)
            if(nums[i] > max)
                return true;
            else if(nums[i] > min)
                max = nums[i];
            else
                min = nums[i];
        return false;
    }
}
