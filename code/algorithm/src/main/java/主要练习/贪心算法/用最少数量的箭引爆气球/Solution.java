package 主要练习.贪心算法.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return Integer.compare(t1[1], t2[1]);
            }
        });
        int count = 0;
        long preEnd = Long.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
            if(points[i][0] > preEnd){
                count++;
                preEnd = points[i][1];
            }
        }
        return count;
    }
}
