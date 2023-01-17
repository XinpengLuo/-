package 主要练习.字符串.最长连续递增序列;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int start = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                start = i;
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
    public int help(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++){
            if(nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
