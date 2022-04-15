package 左神.暴力递归和动态规划.动态规划.刷题.最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                res = Math.max(sum,res);
            }
        }
        return res;
    }
    public int help(int[] nums){
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(arr));
    }
}
