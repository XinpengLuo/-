package 主要练习.暴力递归和动态规划.递归和回溯.刷题.通过连接另一个数组的子数组得到一个数组;

public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        return help(groups,nums,0,0);
    }
    public boolean better(int[][] groups, int[] nums){
        int index = 0;
        for(int i = 0; i < groups.length; i++){
            int[] temp = groups[i];
            boolean flag = false;
            while(index < nums.length && index + temp.length - 1 < nums.length){
                boolean tempFlag = true;
                for(int j = 0; j < temp.length; j++)
                    if(temp[j] != nums[index + j]){
                        tempFlag = false;
                        break;
                    }
                if(tempFlag) {
                    flag = true;
                    index += temp.length;
                    break;
                }
                index++;
            }
            if(!flag)
                return false;
        }
        return true;
    }
    public boolean help(int[][] groups, int[] nums, int i, int j){
        if(i == groups.length)
            return true;
        if(j == nums.length)
            return false;
        for(int k = j; k < nums.length; k++){
            if(nums[k] == groups[i][0] && check(groups[i],nums,k, groups[i].length))
                if(help(groups,nums, i + 1, k + groups[i].length))
                    return true;
        }
        return false;
    }
    public boolean check(int[] A, int[] B, int i, int size){
        if(i + size - 1 >= B.length)
            return false;
        for(int j = 0; j < A.length; j++)
            if(A[j] != B[i + j])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = {{10,-2},{1,2,3,4}};
        int[] nums = {1,2,3,4,10,-2};
        Solution solution = new Solution();
        System.out.println(solution.canChoose(groups, nums));
    }
}
