package 主要练习.数组和矩阵.刷题.最长连续序列;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)){
                int count = 1;
                int curVal = nums[i];
                while (set.contains(curVal + 1)){
                    count++;
                    curVal++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
