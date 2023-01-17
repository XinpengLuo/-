package 主要练习.暴力递归和动态规划.动态规划.刷题.乘积最大子数组;
public class Solution {
    public int maxProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tempRes = nums[i];
            res = Math.max(res,tempRes);
            for(int j = i + 1; j < nums.length; j++){
                tempRes *= nums[j];
                res = Math.max(res,tempRes);
            }
        }
        return res;
    }
    int res = Integer.MIN_VALUE;


    public static void main(String[] args) {
        int[] arr = {2,3,-2,8};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(arr));
    }
}
