package 主要练习.暴力递归和动态规划.动态规划.刷题.删除并获得点数;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]))
                hashMap.put(nums[i],hashMap.get(nums[i]) + 1);
            else
                hashMap.put(nums[i],1);
        }

        return help(nums,0,hashMap);
    }
    public int help(int[] nums, int index,HashMap<Integer,Integer> hashMap){
        if(index >= nums.length)
            return 0;
        int times = hashMap.get(nums[index]);
        int nextIndex = index + times;
        if(nextIndex < nums.length && nums[nextIndex] == nums[index] + 1)
            nextIndex = nextIndex + hashMap.get(nums[nextIndex]);
        return Math.max(nums[index] * times + help(nums,nextIndex,hashMap),help(nums,index + 1,hashMap));
    }
    public int dp(int[] nums,HashMap<Integer,Integer> hashMap){
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        for(int i = dp.length - 2; i >= 0; i--){
            int times = hashMap.get(nums[i]);
            int nextIndex = i + times;
            if(nextIndex < nums.length && nums[nextIndex] == nums[i] + 1)
                nextIndex = nextIndex + hashMap.get(nums[nextIndex]);
            int value = nextIndex >= dp.length ? 0 : dp[nextIndex];
            dp[i] = Math.max(nums[i] * times + value,dp[i + 1]);
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,4,2};
        solution.deleteAndEarn(arr);
    }
}
