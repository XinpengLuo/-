package leetcode.合并区间;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class mergeDemo {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int length = intervals.length;
        for(int i = 0; i < length - 1; i++)
        {
            for(int j = 0; j < length - i - 1; j++)
            {
                if(intervals[j][0] > intervals[j+1][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }

            }
        }
        List<int[]> merge = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if(merge.isEmpty())
                merge.add(interval);
            else{
                int[] temp = merge.get(merge.size() - 1);
                if(interval[0] < temp[1])
                {
                    if(interval[1] > temp[1])
                        temp[1] = interval[1];
                }
                else {
                    merge.add(interval);
                }
            }
        }

    }
}
