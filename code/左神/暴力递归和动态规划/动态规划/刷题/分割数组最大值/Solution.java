package 左神.暴力递归和动态规划.动态规划.刷题.分割数组最大值;

public class Solution {
    public int splitArray(int[] nums, int m) {
        return dfs(nums,m,0,0);
    }
    public int dfs(int[] nums, int m, int sum, int index){
        if(m == 1){
            int temp = 0;
            for(int i = index; i < nums.length; i++)
                temp += nums[i];
            return sum + temp;
        }
        if(index == nums.length)
            return Integer.MAX_VALUE;
        //如果把当前的元素继续归为上一个数组
        return Math.min(dfs(nums, m, sum + nums[index], index + 1),Math.max(sum,dfs(nums,m - 1, nums[index],index + 1)));
    }
    public int binarySearch(int[] nums, int m){
        int left = 0;
        int right = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            left = Math.max(nums[i], left);
            right += nums[i];
        }
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(isValid(nums,middle,m)){
                res = middle;
                right = middle - 1;
            }
            else
                left = middle + 1;
        }
        return res;
    }
    public boolean isValid(int[] nums, int target, int m){
        int sum = 0;
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > target){
                sum = nums[i];
                count++;
            }
            else
                sum += nums[i];
        }
        return count <= m;
    }
}
