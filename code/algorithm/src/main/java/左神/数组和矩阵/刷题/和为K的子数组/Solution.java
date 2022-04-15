package 左神.数组和矩阵.刷题.和为K的子数组;

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            ans += map.getOrDefault(preSum - k,0);
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }
}
