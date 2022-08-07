package 周赛.第305场周赛;

import java.util.*;

public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff)
                        count++;
                }
        return count;
    }
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[nums.length] = true;
        for(int i = dp.length - 2; i >= 0; i--){
            if(i + 1 < nums.length && nums[i + 1] == nums[i])
                dp[i] = dp[i] || dp[i + 2];
            if(i + 2 < nums.length && nums[i + 1] == nums[i] && nums[i + 2] == nums[i])
                dp[i] =  dp[i] || dp[i + 3];
            if(i + 2 < nums.length && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1)
                dp[i] =  dp[i] || dp[i + 3];
        }
        return dp[0];
//        return help(nums,0);
    }
    public boolean help(int[] nums, int index){
        if(index >= nums.length)
            return true;
        boolean res = false;
        if(index + 1 < nums.length && nums[index + 1] == nums[index])
            res = res || help(nums,index + 2);
        if(index + 2 < nums.length && nums[index + 1] == nums[index] && nums[index + 2] == nums[index])
            res = res || help(nums,index + 3);
        if(index + 2 < nums.length && nums[index + 1] - nums[index] == 1 && nums[index + 2] - nums[index + 1] == 1)
            res = res || help(nums,index + 3);
        return res;
    }



    public int longestIdealString(String s, int k) {
        return dfs(s,k,0,-1);
    }

    public int dfs(String s, int k, int index, int preIndex){
        if(index == s.length()) {
            return 0;
        }
        int res = dfs(s,k,index + 1,preIndex);
        if(preIndex == -1 || Math.abs(s.charAt(index) - s.charAt(preIndex)) <= k){
            res = Math.max(res, 1 + dfs(s,k,index + 1,index));
        }
        return res;
    }



    public int dp(String s, int k){
        int[] dp = new int[s.length()];
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            dp[i] = 1;
            char t = s.charAt(i);
            char start = t - k >= 'a' ? (char) (t - k) : 'a';
            char end = t + k <= 'z' ? (char) (t + k) : 'z';
            for(char c = start; c <= end; c++){
                if(map.containsKey(c))
                    dp[i] = Math.max(dp[i], map.get(c) + 1);
            }
            map.put(t,dp[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "acfgbd";
        System.out.println(solution.longestIdealString(s,2));
    }
}
