package 左神.二分总结.寻找右区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];
        for(int i = 0; i < temp.length; i++)
        {
            temp[i][0] = intervals[i][0];
            temp[i][1] = i;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int[] res = new int[intervals.length];
        int index = 0;
        for (int[] interval : intervals) {
            res[index] = -1;
            int end = interval[1];
            int left = 0;
            int right = temp.length - 1;
            while (left <= right){
                int middle = left + (right - left) / 2;
                if(temp[middle][0] >= end){
                    res[index] = temp[middle][1];
                    right--;
                }
                else
                    left++;
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{3,4},{2,3},{1,2}};
        Solution solution = new Solution();
        solution.findRightInterval(test);
    }
}
