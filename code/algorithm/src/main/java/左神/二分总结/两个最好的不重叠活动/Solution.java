package 左神.二分总结.两个最好的不重叠活动;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int[] help = new int[events.length];
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i < help.length; i++){
            help[i] = Math.max(events[i][2],temp);
            temp = help[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < events.length; i++){
            int index = findLastLessTarget(events,events[i][0]);
            if(index == -1)
                ans = Math.max(events[i][2],ans);
            else{
                ans = Math.max(events[i][2] + help[index],ans);
            }
        }
        return ans;
    }
    public int findLastLessTarget(int[][] events, int target){
        int index = -1;
        int l = 0, r = events.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(events[mid][1] < target){
                index = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return index;
    }
}
