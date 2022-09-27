package 左神.位运算.按位与最大的最长子数组;

import 面试真题.快手栈.Main;

public class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++)
            max = Math.max(nums[i],max);
        int ans = 1;
        int j = 1, state = nums[0];
        for(int i = 1; i < nums.length; i++){
            if((state & nums[i]) == max){
                j++;
                state = state & nums[i];
            }
            else{
                state = nums[i];
                j = 1;
            }
            if(state == max){
                ans = Math.max(j,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,2};
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(arr));
    }
}
