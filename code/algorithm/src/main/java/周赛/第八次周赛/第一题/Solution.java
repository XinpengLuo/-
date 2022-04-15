package 周赛.第八次周赛.第一题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    int[] res;
    boolean flag = false;
    public int[] maxSubsequence(int[] nums, int k) {
        res = new int[k];
        System.out.println(dp(nums,k));
         return res;
    }
    public int dp(int[] nums, int k){
        int[][] dp = new int[nums.length + 1][k + 1];
        dp[nums.length][0] = -10000;
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < dp[i].length; j++)
                dp[i][j] = Math.max(j == 0 ? -10000 : dp[i + 1][j - 1] + nums[i],dp[i + 1][j]);
        for(int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[0][k];
    }
    public int getMaxValue(int[] nums, int k, int index){
        if(index >= nums.length){
            if(k == 0)
                return 0;
            return -10000;
        }
        return Math.max(getMaxValue(nums,k - 1,index + 1) + nums[index],
               getMaxValue(nums,k,index + 1));
    }
    public int[] better(int[] nums, int k){


        int[] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = temp.length - 1; i >= temp.length - k; i--)
            map.put(temp[i],map.getOrDefault(temp[i],0 )+ 1);
        int[] res = new int[k];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.getOrDefault(nums[i],0) > 0)
               { res[j++] = nums[i];
                   map.put(nums[i], map.get(nums[i]) - 1);
               }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-76,-694,44,197,357,-833,-277,358,724,-585,-960,214,465,-593,-431,625,-83,58,-889,31,765,8,-17,476,992,803,863,242,379,561,673,526,-447};
        solution.better(arr,2);
    }
}
