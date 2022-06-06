package 左神.暴力递归和动态规划.递归和回溯.刷题.划分为K个相同的子集;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0)
            return false;
        int target = sum / k;
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        if(nums[nums.length - 1] > target)
            return false;
        return dfs(nums,k,0,flag,target,nums.length - 1);
    }
    public boolean dfs(int[] nums, int k, int temp, boolean[] flag, int target, int begin){
        if(k == 1)
            return true;
        if(temp == target)
            return dfs(nums, k - 1,0, flag,target,nums.length - 1);
        for(int i = begin; i >= 0; i--){
            if(flag[i])
                continue;
            if(k == 0)
                return true;


            if(nums[i] == target)
            {
                k--;
                flag[i] = true;
                continue;
            }
            if(temp + nums[i] > target)
                continue;
            flag[i] = true;
            if(dfs(nums,k,temp + nums[i],flag,target, i - 1))
                return true;
            flag[i] = false;
            while(i - 1 >= 0 && nums[i - 1] == nums[i])
                i--;

        }
        if(k == 0)
            return true;
        return false;
    }
}
