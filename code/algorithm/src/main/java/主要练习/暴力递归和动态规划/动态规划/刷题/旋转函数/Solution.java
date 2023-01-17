package 主要练习.暴力递归和动态规划.动态规划.刷题.旋转函数;

public class Solution {
    public int maxRotateFunction(int[] nums) {
        return help(nums,0);
    }
    public int help(int[] nums, int index){
        if(index >= nums.length)
            return Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += i * nums[(index + i) % nums.length];
        }
        return Math.max(sum,help(nums,index + 1));
    }
    public int testFor(int[] nums){
        int index = 0;
        int res = Integer.MIN_VALUE;
        while (index++ < nums.length){
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += i * nums[(index + i) % nums.length];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
     public int standard(int[] nums){
        int preSum = 0;
        int index = 0;
        int sum = 0;
        int pre = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
           {
               preSum += i * nums[(index + i) % nums.length];
               pre = (index + i) % nums.length;
               sum += nums[i];
               res = preSum;
           }
        index++;
        while (index++ < nums.length){
            preSum = preSum + sum - nums.length * nums[pre];
            pre = pre - 1;
            res = Math.max(res,preSum);
        }
        return res;
     }
    public int dp(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = Integer.MIN_VALUE;
        for(int i = dp.length - 2; i >= 0; i--){
            int sum = 0;
            for(int j = 0; j < nums.length; j++)
                sum += j * nums[(j + i) % nums.length];
            dp[i] = Math.max(sum,dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
       Solution solution = new Solution();
        System.out.println(solution.standard(nums));
        System.out.println(solution.dp(nums));
    }
}
