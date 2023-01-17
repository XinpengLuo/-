package 主要练习.栈和队列.会议室3;

import java.util.*;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (t1, t2) -> t1[0] - t2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((t1, t2) -> {
            if(t1[1] == t2[1])
                return t1[0] - t2[0];
            return t1[1] - t2[1];
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
            rooms.add(i);
        int index = 0;
        while(index < meetings.length){
            while (!queue.isEmpty() && queue.peek()[1] <= meetings[index][0]){
                int[] poll = queue.poll();
                rooms.add(poll[0]);
            }
            if(!rooms.isEmpty()){
                int minRoom = rooms.poll();
                count[minRoom]++;
                int[] arr = new int[]{minRoom,meetings[index][1]};
                queue.add(arr);
            }
            else{
                int[] poll = queue.poll();
                int len = meetings[index][1] - meetings[index][0];
                poll[1] = poll[1] + len;
                count[poll[0]]++;
                queue.add(poll);
            }
            index++;
        }
        int max = 0, res = -1;
        for(int i = 0; i < count.length; i++){
            if(count[i] > max){
                max = count[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{0,10},{1,2},{12,14},{13,15}};
        Solution solution = new Solution();
        System.out.println(solution.mostBooked(3, meetings));
    }
}
