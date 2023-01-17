package 主要练习.数组和矩阵.刷题.颜色分类荷兰国旗问题;

import java.util.Arrays;

public class Solution {
    //将小于等于target的数字 放在左边 大于它的放在右边
    public void partition(int[] nums, int target){
        int i = -1, cur = 0;
        while (cur < nums.length){
            if(nums[cur] <= target)
                swap(nums,++i,cur);
            cur++;
        }
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int target = 1;
        int left = -1, right = nums.length, cur = 0;
        while (cur < right){
            if(nums[cur] == target)
                cur++;
            else if(nums[cur] < target)
                swap(nums,cur++,++left);
            else if(nums[cur] > target)
                swap(nums,cur,--right);

        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.partition(nums,1);
        System.out.println(Arrays.toString(nums));
    }
}
