package 左神.栈和队列.单调栈.子数组最小乘积的最大值;

import java.util.*;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        long res = 0;
        int mod = (int) (Math.pow(10,9) + 7);
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        Arrays.fill(right,-1);
        Arrays.fill(left,-1);
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index < nums.length){
            if(stack.isEmpty() || nums[stack.peek()] <= nums[index]){
                stack.push(index);
                index++;
                continue;
            }
            int i = stack.pop();
            right[i] = index;

        }
        stack.clear();
        index = nums.length - 1;
        while(index >= 0){
            if(stack.isEmpty() || nums[stack.peek()] <= nums[index]){
                stack.push(index);
                index--;
                continue;
            }
            int i = stack.pop();
            left[i] = index;
        }
        for(int i = 0; i < left.length; i++){
            long leftSum = left[i] == -1 ? 0 : sum[left[i]];
            long rightSum = right[i] == -1 ? sum[nums.length - 1] : sum[right[i] - 1];
            long temp = rightSum - leftSum;
            res = Math.max(res, temp * nums[i]);
        }
        return (int)(res % mod) ;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        Solution solution = new Solution();
        System.out.println(solution.maxSumMinProduct(nums));
    }
}