package 主要练习.滑动窗口.删掉一个元素以后全为1的最长子数组;

public class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        boolean flag = false;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(flag && nums[i] == 0){
                while (nums[j] != 0)
                    j++;
                j++;
                flag = false;
            }
            if(nums[i] == 0)
                flag = true;
            ans = Math.max(i - j, ans);
        }
        return ans;
    }
}
