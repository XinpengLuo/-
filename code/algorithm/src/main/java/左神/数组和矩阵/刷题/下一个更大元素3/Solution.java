package 左神.数组和矩阵.刷题.下一个更大元素3;

public class Solution {
    public int nextGreaterElement(int n) {
        String s = n + "";
        int[] nums = new int[s.length()];
        for(int i = 0; i < nums.length; i++)
            nums[i] = s.charAt(i) - '0';
        if(nums.length <= 1)
            return -1;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i < 0)
            return -1;
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i])
            j--;
        swap(nums,i,j);
        int start = i + 1, end = nums.length - 1;
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
        long res = 0;
        for (int num : nums) {
            res = res * 10 + num;
        }
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
