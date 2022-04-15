package 左神.二分总结.有序矩阵中第K小的元素;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return matrix[t1[0]][t1[1]] - matrix[t2[0]][t2[1]];
            }
        });
        for(int i = 0; i < matrix.length; i++)
            priorityQueue.add(new int[]{i,0});
        int ans = 0;
        while (k-- > 0 && !priorityQueue.isEmpty()){
            int[] temp = priorityQueue.poll();
            ans = matrix[temp[0]][temp[1]];
            if(temp[1] + 1 < matrix[0].length)
                priorityQueue.add(new int[]{temp[0],temp[1] + 1});
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(solution.kthSmallest(matrix, 8));
    }
}
