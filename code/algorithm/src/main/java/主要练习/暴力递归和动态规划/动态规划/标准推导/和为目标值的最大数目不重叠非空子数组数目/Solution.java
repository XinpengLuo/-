package 主要练习.暴力递归和动态规划.动态规划.标准推导.和为目标值的最大数目不重叠非空子数组数目;

public class Solution {
}
class Test{
    //递归版本
    public int maxNonOverlapping(int[] nums, int target) {
        return help(nums,target,0,0);
    }
    public int help(int[] nums, int target, int index, int tempSum){
        if(target == tempSum)
        {
            return 1 + help(nums,target,index + 1,0);
        }
        if(index >= nums.length)
            return 0;
        return help(nums,target,index + 1,tempSum + nums[index]);
    }
}