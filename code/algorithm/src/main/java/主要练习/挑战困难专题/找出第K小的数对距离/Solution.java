package 主要练习.挑战困难专题.找出第K小的数对距离;

import java.util.*;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            //mid代表数对距离 求所有小于或者等于mid的数量
            int count = 0;

            for(int i = 0; i < nums.length; i++){ // nums[i] - x <= mid
                int index = countByBS(nums,nums[i] - mid);
                if(index != -1 && index < i)
                    count += i - index;
            }

            if(count >= k){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;
    }
    public int countByBS(int[] nums, int target){
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                index = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1};
        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(arr, 1));
    }
}
