package 左神.位运算.连续数组;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); //sum --> index
        int sum = 0;
        map.put(0,-1);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(sum))
                res = Math.max(res, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return res;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(arr,2));
    }
}
