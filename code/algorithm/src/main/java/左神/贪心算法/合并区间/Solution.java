package 左神.贪心算法.合并区间;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals,(t1,t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0]);
        int index = 0;
        while(index < intervals.length){
            int pre = intervals[index][1];
            int start = intervals[index][0];
            while(index < intervals.length && intervals[index][0] <= pre){
                pre = Math.max(pre,intervals[index][1]);
                index++;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(pre);
            list.add(temp);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
}
