package 主要练习.数组和矩阵.刷题.最长和谐子序列;

import java.util.Arrays;

public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        while (i < nums.length){
            int start = i;
            while (i < nums.length && nums[i] == nums[start])
                i++;
            if(i == nums.length)
                break;
            int end = i;
            if(nums[i] - nums[start] == 1)
                while (i < nums.length && nums[i] == nums[end])
                    i++;
            ans = Math.max(ans,i - start);
            i = end;
        }
        return ans;
    }
}
