package 主要练习.数组和矩阵.刷题.查找和最小的K对数字;
import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return nums1[t1[0]] + nums2[t1[1]] - nums1[t2[0]] - nums2[t2[1]];
            }
        });
        for(int i = 0; i < nums1.length; i++)
            priorityQueue.add(new int[]{i,0});
        while (!priorityQueue.isEmpty() && k-- > 0){
            int[] temp = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            if(temp[1] + 1 < nums2.length)
                priorityQueue.add(new int[]{temp[0],temp[1] + 1});
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3};
        Solution solution = new Solution();
        solution.kSmallestPairs(num1,num2,3);
    }
//    public int findMaxNumber(int[] arr){
//
//    }
//
//    public static void main(String[] args) {
//
//    }
}
