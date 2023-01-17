package 主要练习.数组和矩阵.刷题.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

public class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < nums.length && nums[i] % 2 != 0)
                i++;
            while (j >= 0 && nums[j] % 2 == 0)
                j--;
            if(i >= j)
                break;
            swap(nums,i,j);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        solution.exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
