package 主要练习.数组和矩阵.刷题.滑动窗口最大值;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0] != t1[0] ? t2[0] - t1[0] : t2[1] - t1[1];
            }
        });
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            queue.add(new int[]{nums[i],i});
            if(i >= k - 1){
                while (queue.peek()[1] < (i - k + 1))
                    queue.poll();
                res[j] = queue.peek()[0];
                j++;
            }
        }
        return res;
    }
    public int[] better(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if(i >= k - 1){
                while (deque.peekFirst() < (i - k + 1))
                    deque.pollFirst();
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
    public int[] another(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0) + 1);
            if(i >= k - 1){
                res[j] = treeMap.lastKey();
                if(treeMap.get(nums[j]) == 1)
                    treeMap.remove(nums[j]);
                else
                    treeMap.put(nums[j],treeMap.get(nums[j]) - 1);
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1,-1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, 1)));
        System.out.println(Arrays.toString(solution.better(arr, 1)));
        System.out.println(Arrays.toString(solution.another(arr,1)));
    }
}
