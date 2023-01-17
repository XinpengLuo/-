package 主要练习.双指针.旋转数组;

public class Solution {
    public void rotateOne(int[] nums, int k) { //开辟一个新的数组 用来存储
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++)
            arr[(i + k) % nums.length] = nums[i];
        for(int i = 0; i < arr.length; i++)
            nums[i] = arr[i];
    }
    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k);
        reverse(nums,k + 1, nums.length  -1);
    }
    public void reverse(int[] nums, int i, int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
