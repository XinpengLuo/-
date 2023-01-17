package 主要练习.数组和矩阵.刷题.数组的度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++)
            {
                int count = map.getOrDefault(nums[i],0) + 1;
                maxCount = Math.max(count,maxCount);
                map.put(nums[i],count);
            }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxCount){
                ans = Math.min(ans,getLength(nums,entry.getKey()));
            }
        }
        return ans;
    }
    public int getLength(int[] nums, int maxNumber){
        boolean firstIs = true;
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == maxNumber){
                if(firstIs){
                    start = i;
                    firstIs = false;
                }
                end = i;
            }
        }
        return end - start + 1;
    }
    public int better(int[] nums){
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
            else{
                map.put(nums[i],new int[]{1,i,i});
            }
            maxCount = Math.max(maxCount,map.get(nums[i])[0]);
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if(entry.getValue()[0] == maxCount)
                ans = Math.min(entry.getValue()[2] - entry.getValue()[1] + 1, ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,2,3,1};
        System.out.println(solution.findShortestSubArray(arr));
    }
}
