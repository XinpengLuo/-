package 左神.数组和矩阵.刷题.区间子数组个数;

import java.util.Arrays;

public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
         int ans = 0;
         int preSum = 0;
         int preBreak = -1;
         for(int i = 0; i < nums.length; i++){
             if(nums[i] >= left && nums[i] <= right){
                 preSum = i - preBreak;
                 ans += preSum;
             }
             else if(nums[i] < left)
                 ans += preSum;
             else if(nums[i] > right)
                 preBreak = i;
         }
         return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,9,2,5,6};
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayBoundedMax(arr, 2, 8));
    }
}
