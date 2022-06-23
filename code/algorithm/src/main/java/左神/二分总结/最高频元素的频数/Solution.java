package 左神.二分总结.最高频元素的频数;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);
       int res = 0;
       long sum = 0;
       int j = 0;
       for(int i = 1; i < nums.length; i++){
           sum += ((nums[i] - nums[i - 1]) * (i - j));
           while (sum > k){
               sum -= (nums[i] - nums[j]);
               j--;
           }
           res = Math.max(res, i - j + 1);
       }
       return res;
    }
}
