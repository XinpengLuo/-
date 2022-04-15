package 左神.数组和矩阵.刷题.分割等和子集;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        double target = sum / 2.0;
        if(target != sum / 2)
            return false;
//        return help(nums,0,sum / 2,0);
        return dp(nums,sum / 2);
    }
    public boolean dp(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][dp[i].length - 1] = true;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < dp[i].length - 1; j++)
                dp[i][j] = dp[i + 1][j] || (j + nums[i] > target ? false : dp[i + 1][j + nums[i]]);
        return dp[0][0];
    }
    public boolean help(int[] nums, int index, int target, int tempSum){
        if(tempSum == target)
            return true;
        if(index == nums.length)
            return false;
        return help(nums,index + 1,target,tempSum) || help(nums,index + 1,target,tempSum + nums[index]);
    }

    public static void main(String[] args) {
        Double a = 9 / 2.0;
        System.out.println(a == 4);
        System.out.println(a);
    }
}
