package 主要练习.滑动窗口.最大连续1的个数III;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && k == 0){
                while (nums[j] == 1)
                    j++;
                j++;
                k++;
            }
            if(nums[i] == 0)
                k--;
            ans = Math.max(i - j + 1,ans);
        }
        return ans;
    }
}
