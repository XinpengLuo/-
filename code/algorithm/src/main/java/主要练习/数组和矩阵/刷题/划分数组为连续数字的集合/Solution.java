package 主要练习.数组和矩阵.刷题.划分数组为连续数字的集合;

import java.util.*;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i] - 1)){
                PriorityQueue<Integer> queue = map.get(nums[i] - 1);
                int temp = queue.poll();
                if(map.get(nums[i] - 1).size() == 0)
                    map.remove(nums[i] - 1);
                if(temp + 1 != k) {
                    PriorityQueue<Integer> newQueue;
                    if (map.containsKey(nums[i]))
                        newQueue = map.get(nums[i]);
                    else {
                        newQueue = new PriorityQueue<>();
                    }
                    newQueue.add(temp + 1);
                    map.put(nums[i], newQueue);
                }
            }
            else{
                PriorityQueue<Integer> queue = map.getOrDefault(nums[i], new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer t1, Integer t2) {
                        return t2 - t1;
                    }
                }));
                queue.add(1);
                map.put(nums[i],queue);
            }
        }
        return map.size() == 0;
    }
}