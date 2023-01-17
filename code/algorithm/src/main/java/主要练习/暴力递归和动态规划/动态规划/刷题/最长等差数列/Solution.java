package 主要练习.暴力递归和动态规划.动态规划.刷题.最长等差数列;

public class Solution {
    //超时版本 枚举每一个公差
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        int res = 0;
        for(int i = 0; i <= 1000; i++){
            int diff = i - 500;
            for(int j = 0; j < nums.length; j++){
                {
                    dp[j][i] = 1;
                    for(int k = 0; k < j; k++)
                        if(nums[k] + diff == nums[j])
                            dp[j][i] = Math.max(dp[j][i],dp[k][i] + 1);
                }
            res = Math.max(res,dp[j][i]);
            }
        }
        return res;
    }
    public int better(int[] nums){
        int[][] dp = new int[nums.length][1001];
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = dp[j][diff] + 1;
                res = Math.max(dp[i][diff],res);
            }
        return res + 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {20,1,15,3,10,5,8};

        System.out.println(solution.longestArithSeqLength(arr));
    }
}
