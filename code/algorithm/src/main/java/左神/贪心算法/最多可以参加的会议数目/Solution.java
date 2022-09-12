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
                return t1[0] - t2[0];
            }
        });
        int index = 0, day = 0;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(index < events.length || !queue.isEmpty()){
            while (index < events.length && events[index][0] == day){
                queue.add(events[index][1]);
                index++;
            }
            while (!queue.isEmpty() && queue.peek() < day)
                queue.poll();
            if(!queue.isEmpty()){
                count++;
                queue.poll();
            }
            day++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,1},{1,2},{2,2}};
        System.out.println(solution.maxEvents(arr));
    }
}
