package 主要练习.数组和矩阵.刷题.数组嵌套;

import java.util.*;

public class Solution {
    int max = 0;
    public int arrayNesting(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != Integer.MIN_VALUE) {
                max = Math.max(max, help(nums, i, new HashSet<>()));
            }
        }
        return max;
    }
    public int help(int[] nums, int val, HashSet<Integer> set){
        int count = 0;
        while (!set.contains(nums[val])){
            set.add(nums[val]);
            val = nums[val];
            nums[val] = Integer.MIN_VALUE;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,0,3,1,6,2};
        Solution solution = new Solution();
        System.out.println(solution.arrayNesting(arr));
    }
}
