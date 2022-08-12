package 左神.数组和矩阵.刷题.最接近的三数之和;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == target)
                    return temp;
                int diff = Math.abs(temp - target);
                if(diff < res){
                    res = diff;
                    ans = temp;
                }
                if(temp > target)
                    right--;
                else if(temp < target)
                    left++;
            }
        }
        return ans;
    }
}
