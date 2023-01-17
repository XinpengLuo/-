package 主要练习.数组和矩阵.刷题.前k个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer temp : map.keySet()) {
            if(heap.size() < k)
                heap.add(temp);
            else{
                if(map.get(temp) > map.get(heap.peek())){
                    heap.remove();
                    heap.add(temp);
                }
            }
        }
        int[] ans = new int[k];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = heap.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,1,2,2,3};
        solution.topKFrequent(arr,2);
    }
}
