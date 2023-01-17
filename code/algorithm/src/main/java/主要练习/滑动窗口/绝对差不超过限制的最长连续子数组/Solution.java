package 主要练习.滑动窗口.绝对差不超过限制的最长连续子数组;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int j = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit){
                if(treeMap.get(nums[j]) == 1)
                    treeMap.remove(nums[j]);
                else
                    treeMap.put(nums[j],treeMap.get(nums[j]) - 1);
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
    //滑动窗口 加上单调队列
    public int better(int[] nums, int limit){
        int res = 0;
        int j = 0;
        //维护最大值的队列
        Deque<Integer> max = new LinkedList<>();
        //维护最小值的队列
        Deque<Integer> min = new LinkedList<>();
        for(int i = 0; i < nums.length; i++)
           {
               while (!max.isEmpty() && nums[max.peekLast()] < nums[i])
                   max.pollLast();
               while (!min.isEmpty() && nums[min.peekLast()] > nums[i])
                   min.pollLast();
               max.offerLast(i);
               min.offerLast(i);
               while (!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > limit){
                   if(nums[j] == nums[min.peekFirst()])
                       min.pollFirst();
                   if(nums[j] == nums[max.peekFirst()])
                       max.pollFirst();
                   j++;
               }
               res = Math.max(res, i - j  + 1);
           }
        return res;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr =  {4,2,2,2,4,4,2,2};
        System.out.println(solution.longestSubarray(arr, 0));
    }
}
