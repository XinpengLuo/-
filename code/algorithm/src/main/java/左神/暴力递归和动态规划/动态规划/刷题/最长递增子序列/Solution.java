package 左神.暴力递归和动态规划.动态规划.刷题.最长递增子序列;

class Solution {
    public int lengthOfLIS(int[] nums) {
        return help(nums,0,Integer.MIN_VALUE);
    }
    public int help(int[] nums, int index, int preValue){
        if(index >= nums.length)
            return 0;
        if(nums[index] > preValue)
            return Math.max(1 + help(nums,index + 1,nums[index]),help(nums,index + 1,preValue));
        return help(nums,index + 1,preValue);
    }
    public int dp(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < dp.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    //最长递增子序列的个数 要做到边赋值边记述
    public int getDp(int[] nums){
        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 1;
        }
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < dp.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                   {
                       if(dp[j] + 1 > dp[i]){
                           dp[i] = dp[j] + 1;
                           counts[i] = counts[j];
                       }
                       else if(dp[j] + 1 == dp[i])
                           counts[i] += counts[j];
                   }
            }
            maxLength = Math.max(dp[i],maxLength);
            }
        int count = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == maxLength)
                count += counts[i];
        }
        return count;
        }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,5,4,7};
        System.out.println(solution.getDp(arr));
    }
}
