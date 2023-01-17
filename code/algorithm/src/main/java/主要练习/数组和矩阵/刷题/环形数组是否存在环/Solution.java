package 主要练习.数组和矩阵.刷题.环形数组是否存在环;

import java.util.*;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> set = new HashSet<>();
            boolean flag = nums[i] > 0;
            int index = i;
            while(!set.contains(index)){
                if((nums[index] < 0 && flag) || (nums[index] > 0 && !flag))
                    break;
                set.add(index);
                index = (((index + nums[index] + nums.length) % nums.length) + nums.length) % nums.length;
            }
            if(index == i && set.size() > 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,-9};
        Solution solution = new Solution();
        System.out.println(solution.circularArrayLoop(arr));
    }
}