package 主要练习.数组和矩阵.刷题.和相同的二元子数组;

import java.util.HashMap;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            map.put(sum,map.getOrDefault(sum,0) + 1);
            sum += num;
            ans += map.getOrDefault(sum - goal,0);
        }
        return ans;
    }
}
