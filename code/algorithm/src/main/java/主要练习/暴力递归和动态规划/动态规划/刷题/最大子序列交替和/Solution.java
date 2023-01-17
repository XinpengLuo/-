package 主要练习.暴力递归和动态规划.动态规划.刷题.最大子序列交替和;

public class Solution {
    public long maxSum(int[] nums, int index, boolean flag){ //flag --> true 当前子序列index为正
        if(index == nums.length)
            return 0;
        long res = Long.MIN_VALUE;
        if(flag)
            res = Math.max(nums[index] + maxSum(nums,index + 1,false),maxSum(nums,index + 1,true));
        else
            res = Math.max(maxSum(nums,index + 1,true) - nums[index],maxSum(nums,index + 1,false));
        return res;
    }
    public long dp(int[] nums){
        long a = 0;
        long b = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            long c = Math.max(nums[i] + b,a);
            long d = Math.max(a - nums[i],b);
            a = c;
            b = d;
        }
        return Math.max(a,b);
    }

    public long maxAlternatingSum(int[] nums) {
        long a = nums[0]; //0 --> 偶数
        long b = 0;
        for(int i = 1; i < nums.length; i++){
            //如果要让当前子序列以偶数个数结尾
            long temp = a;
            a = b + nums[i];
            b = temp - nums[i];
        }
        return Math.max(a,b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6,2,1,2,4,5};
        System.out.println(solution.maxSum(arr,0,true));
        System.out.println(solution.dp(arr));
    }
}
