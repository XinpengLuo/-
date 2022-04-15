package 左神.数组和矩阵.刷题.把数组排成最小的数;

public class Solution {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        for(int i = 0; i < nums.length - 1; i++)
            for(int j = 0; j < nums.length - 1 - i; j++){
                if((strs[j] + strs[j + 1]).compareTo(strs[j + 1] + strs[j]) > 0)
                    swap(strs,j,j + 1);
            }
        for(int i = 0; i < nums.length; i++)
            sb.append(strs[i]);
        return sb.toString();
    }
    public void swap(String[] nums, int i, int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,30,34,5,9};
        System.out.println(solution.minNumber(arr));
    }
}
