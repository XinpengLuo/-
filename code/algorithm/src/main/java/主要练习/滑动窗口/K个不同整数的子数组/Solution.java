package 主要练习.滑动窗口.K个不同整数的子数组;

import java.util.*;

public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return help(nums,k) - help(nums, k - 1);
    }

    public int help(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            while(map.size() > k){
                int key = nums[j];
                if(map.get(key) == 1)
                    map.remove(key);
                else
                    map.put(key,map.get(key) - 1);
                j++;
            }
            res += (i - j + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,1,2,3};
        System.out.println(solution.subarraysWithKDistinct(arr, 2));
    }
}
