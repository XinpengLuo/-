package 左神.数组和矩阵.刷题.下一个排列;

public class Solution {
    public void nextPermutation(int[] nums) {
        int j = -1;
        for(int i = nums.length - 1; i >= 1; i--)
            if(nums[i - 1] < nums[i])
                {
                    j = i;
                    break;
                }

        int k = nums.length - 1;
        for(; k >= j; k--)
            if(nums[k] > nums[j - 1])
                break;
        int temp = nums[j - 1];
        nums[j - 1] = nums[k];
        nums[k] = temp;
        int start = j == - 1 ? 0 : j, end = nums.length - 1;
        while (start < end){
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
    public void next(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i > 0){
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i])
                j--;
            swap(nums,i,j);
        }
        int start = i + 1, end = nums.length - 1;
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        Solution solution = new Solution();
        solution.nextPermutation(arr);
    }
}
