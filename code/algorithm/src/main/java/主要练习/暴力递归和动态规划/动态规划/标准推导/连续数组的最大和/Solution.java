package 主要练习.暴力递归和动态规划.动态规划.标准推导.连续数组的最大和;

public class Solution {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1],0);
            res = Math.max(nums[i],res);
        }
        return res;
    }
}
class Test{
    //题目为 从一个数组中任意选择多少个数字 求选出来的数字的和最大值
    int maxSum = Integer.MIN_VALUE;
    public int selectMaxSum(int[] nums) {
        return help(nums,0);
    }
    public int help(int[] nums,int i){
        if(i == nums.length){
            return 0;
        }
        return Math.max(nums[i] + help(nums,i + 1),help(nums, i + 1));

    }
    //动态规划版本 好像不是。。。。
    public int selectMaxSumDp(int[] nums){
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = Math.max(nums[nums.length - 1],0); //dp中的每个元素代表从右往左 以当前元素结尾的子数组中最大的雷累加和
        for(int i = nums.length - 2; i >= 0; i--)
        {
            dp[i] = Math.max(nums[i] + dp[i + 1],dp[i + 1]);
        }
        //dp中第一个元素就是所有数组都考虑进去的最大累加和
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,14};
        Test test = new Test();
        System.out.println(test.selectMaxSum(arr));
        System.out.println(test.selectMaxSumDp(arr));
    }
}
