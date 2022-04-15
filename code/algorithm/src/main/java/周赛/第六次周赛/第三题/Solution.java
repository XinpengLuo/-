package 周赛.第六次周赛.第三题;

import javax.swing.*;

public class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return 2;
        int maxIndex = 0, maxValue = nums[0];
        int minIndex = 0, minValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
            else if(nums[i] < minValue){
                minValue = nums[i];
                minIndex = i;
            }
        }
        int res = Integer.MAX_VALUE;
        if(maxIndex > minIndex){
            res = Math.min(res,minIndex + 1 + nums.length - maxIndex);
            res = Math.min(res,maxIndex + 1);
            res = Math.min(res,nums.length - minIndex);
        }
        else{
            res = Math.min(res,maxIndex + 1 + nums.length - minIndex);
            res = Math.min(res,minIndex + 1);
            res = Math.min(res,nums.length - maxIndex);
        }
        return res;
    }
    public int better(int[] nums){
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return 2;
        int maxIndex = 0, maxValue = nums[0];
        int minIndex = 0, minValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
            else if(nums[i] < minValue){
                minValue = nums[i];
                minIndex = i;
            }
        }
        int l = Math.min(maxIndex,minIndex);
        int r = Math.max(maxIndex,minIndex);
        return Math.min(Math.min(r + 1,l + 1 + nums.length - r),nums.length - l);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {-14,61,29,-18,59,13,-67,-16,55,-57,7,74};
        System.out.println(solution.minimumDeletions(arr));
    }
}
