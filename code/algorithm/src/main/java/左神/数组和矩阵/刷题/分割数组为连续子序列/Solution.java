package 左神.数组和矩阵.刷题.分割数组为连续子序列;

import java.util.*;

public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i] - 1)){
                PriorityQueue<Integer> queue = map.get(nums[i] - 1);
                int temp = queue.poll();
                if(map.get(nums[i] - 1).size() == 0)
                    map.remove(nums[i] - 1);
                PriorityQueue<Integer> newQueue;
                if(map.containsKey(nums[i]))
                    newQueue = map.get(nums[i]);
                else{
                    newQueue = new PriorityQueue<>();
                }
                newQueue.add(temp + 1);
                map.put(nums[i],newQueue);
            }
            else{
                PriorityQueue<Integer> queue = map.getOrDefault(nums[i], new PriorityQueue<>());
                queue.add(1);
                map.put(nums[i],queue);
            }
        }
        for (Integer integer : map.keySet()) {
            for (Integer temp : map.get(integer)) {
                if(temp < 3)
                    return false;
            }
        }
        return true;
    }
}
