package 左神.滑动窗口.删除子数组的最大得分;

import java.util.HashSet;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int j = 0; //左指针
        for(int i = 0; i < nums.length; i++){
            while (set.contains(nums[i]))
                {
                    sum -= nums[j];
                    set.remove(nums[j]);
                    j++;
                }
            sum += nums[i];
            set.add(nums[i]);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
