package 左神.贪心算法.最多可以参加的会议数目;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int count = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < events.length; i++){
            int s = events[i][0];
            int e = events[i][1];
            for(int j = s; j <= e; j++){
                if(!set.contains(j)){
                    set.add(j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
