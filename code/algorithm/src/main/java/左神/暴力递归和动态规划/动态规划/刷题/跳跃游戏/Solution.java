package 左神.暴力递归和动态规划.动态规划.刷题.跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        return canJumpHelp(nums,0);
    }
    public boolean canJumpHelp(int[] nums, int index){
        if(index == nums.length - 1)
            return true;
        if(index >= nums.length || nums[index] == 0)
            return false;
        for (int i = 1; i <= nums[index]; i++) {
           if(canJumpHelp(nums,index + i))
               return true;
        }
        return false;
    }
    public boolean dp(int[] nums){
        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                boolean flag = i + j >= dp.length ? false : dp[i + j];
                if(flag)
                    dp[i] = true;
            }
        }
        return dp[0];
    }
}
