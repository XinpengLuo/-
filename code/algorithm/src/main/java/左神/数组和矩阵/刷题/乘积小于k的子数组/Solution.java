package 左神.数组和矩阵.刷题.乘积小于k的子数组;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int l = 0, r = 0, preCount = 1;
        while (r < nums.length && l < nums.length){
            preCount *= nums[r];
            while (preCount >= k && l <= r){
                preCount = preCount / nums[l];
                l++;
            }
            ans += (r - l + 1);
            r++;

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10,5,2,6};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 100));
    }
}
