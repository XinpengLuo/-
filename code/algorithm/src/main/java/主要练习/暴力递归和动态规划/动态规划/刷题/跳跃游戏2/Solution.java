package 主要练习.暴力递归和动态规划.动态规划.刷题.跳跃游戏2;

public class Solution {
    public int jump(int[] nums) {
        return help(nums,0);
    }
    public int help(int[] nums, int index){
        if(index == nums.length - 1)
            return 0;
        int res = 100000;
        if(index > nums.length - 1 || nums[index] == 0)
            return res;
        for (int i = 1; i <= nums[index]; i++) {
            res = Math.min(res,1 + help(nums,index + i));
        }
        return res;
    }
    public int dp(int[] nums){
        int[] dp = new int[nums.length];
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i] = 100000;
            for(int j = 1; j <= nums[i]; j++)
                dp[i] = Math.min(dp[i],1 + getValue(dp,i + j));
        }
        return dp[0];
    }
    public int getValue(int[] dp, int index){
        if(index >= dp.length)
            return 100000;
        return dp[index];
    }
}
class Again{
    public int jump(int[] nums){
        return help(nums,0);
    }
    public int help(int[] nums, int index){
        if(index >= nums.length - 1)
            return 0;
        if(nums[index] == 0)
            return 10000;
        int ans = 10000;
        for(int i = 1; i <= nums[index]; i++)
            ans = Math.min(ans, help(nums,index + i));
        return ans + 1;
    }
    public int dp(int[] nums){
        int[] dp = new int[nums.length];
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i] = 10000;
            if(nums[i] == 0)
                continue;
            for(int j = 1; j <= nums[i]; j++)
                dp[i] = Math.min(dp[i],(i + j >= nums.length - 1 ? 0 : dp[i + j]) + 1);
        }
        return dp[0];
    }
}
