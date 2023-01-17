package 主要练习.数组和矩阵.刷题.最短无序连续子数组;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        boolean flag = true;
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i + 1] < nums[i])
                flag = false;
        if(flag)
            return 0;
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] == temp[left])
            left++;
        while (right >= 0 && nums[right] == temp[right])
            right--;
        return right - left + 1;
    }
    public int findUnsortedSubArray(int[] nums){
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }
    public int findUnsortedByDoublePoint(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int n = nums.length;
        int r = -1, l = -1;
        for(int i = 0; i <= nums.length; i++){
            if(nums[i] > maxValue)
                maxValue = nums[i];
            else
                r = i;
            if(nums[n - i - 1] <= minValue)
                minValue = nums[n - i - 1];
            else
                l = n - i - 1;
        }
        return r == -1 ? 0 : r - l + 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(solution.findUnsortedSubarray(arr));
        System.out.println(solution.findUnsortedSubArray(arr));
        System.out.println(solution.findUnsortedByDoublePoint(arr));
    }
}
