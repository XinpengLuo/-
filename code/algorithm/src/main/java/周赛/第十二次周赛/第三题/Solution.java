package 周赛.第十二次周赛.第三题;

public class Solution {
    public int maximumTop(int[] nums, int k) {
        if(nums.length == 1){
            if(k % 2 != 0)
                return -1;
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < Math.min(nums.length,k - 1); i++)
            max = Math.max(nums[i],max);
        if(k < nums.length)
            max = Math.max(nums[k],max);
        return max;
    }
}
