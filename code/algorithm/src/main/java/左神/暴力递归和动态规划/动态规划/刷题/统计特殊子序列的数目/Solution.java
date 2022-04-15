package 左神.暴力递归和动态规划.动态规划.刷题.统计特殊子序列的数目;

public class Solution {
    public int countSpecialSubsequences(int[] nums) {
        return help(nums,0,0,1);
    }
    public int help(int[] nums, int index, int preValue,int count){
        if(index >= nums.length)
        {
            if(count >= 3)
                return 1;
            return 0;
        }
        if(preValue == 0 && nums[index] == 1)
            return help(nums,index + 1,1,count + 1) + help(nums,index + 1,preValue,count);
        if(preValue == 1 && nums[index] == 2)
            return help(nums,index + 1,2,count + 1) + help(nums,index + 1,preValue,count);
        if(preValue == 2 && nums[index] == 2)
            return help(nums,index + 1,2,count + 1) + help(nums,index + 1,preValue,count);
        return help(nums,index + 1,preValue,count);
    }

    public static void main(String[] args) {
        //[0,0,1,1,2,2,0,0]  -- > 27
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,2,2,0,0};
        System.out.println(solution.countSpecialSubsequences(nums));
    }
}
