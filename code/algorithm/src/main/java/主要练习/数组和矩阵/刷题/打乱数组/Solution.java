package 主要练习.数组和矩阵.刷题.打乱数组;

import java.util.Random;

public class Solution {
    int[] data;
    int[] origin;
    public Solution(int[] nums) {
        data = new int[nums.length];
        origin = new int[nums.length];
        System.arraycopy(nums,0,data,0,nums.length);
        System.arraycopy(nums,0,origin,0,nums.length);
    }

    public int[] reset() {
        System.arraycopy(origin,0,data,0,data.length);
        return data;
    }

    public int[] shuffle() {
        for(int i = 0; i < data.length; i++){
            Random random = new Random();
            int j = random.nextInt(data.length - i) + i;
            swap(data,i,j);
        }
        return data;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
