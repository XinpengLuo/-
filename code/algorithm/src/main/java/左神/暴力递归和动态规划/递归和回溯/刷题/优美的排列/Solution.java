package 左神.暴力递归和动态规划.递归和回溯.刷题.优美的排列;

import java.util.Arrays;

public class Solution {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        return help(nums,0);
    }
    public int help(int[] nums, int index){
        if(index == nums.length)
            {
                System.out.println(Arrays.toString(nums));
                return 1;
            }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            swap(nums,i,index);
            if((nums[index] % (index + 1) == 0) || ((index + 1) % nums[index] == 0))
                res += help(nums,index + 1);
            swap(nums,i,index);
        }
        return res;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countArrangement(3));
    }
}
