package 周赛.第六次周赛.第一题;

import java.util.Arrays;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        long[] preSum = new long[nums.length];
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            preSum[i] = sum;
        }
        int index = 0;
        while (index < res.length){
            if(index < k || index + k >= nums.length){
                res[index] = -1;
                index++;
                continue;
            }
            long leftValue = (preSum[index] - preSum[index - k] + nums[index - k]);
            long rightValue =  (preSum[index + k] - preSum[index]);
            res[index] = (int)((leftValue + rightValue) / (2 * k + 1));
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(solution.getAverages(arr, 3)));
    }
}
