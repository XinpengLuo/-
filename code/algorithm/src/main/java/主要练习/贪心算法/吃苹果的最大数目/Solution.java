package 主要练习.贪心算法.吃苹果的最大数目;

import java.util.*;

public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int day = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int index = 0;
        int res = 0;
        while (index < apples.length || !queue.isEmpty()){
            if(index < apples.length){
                if(apples[index] != 0) {
                    int[] temp = new int[]{apples[index], index + 1 + days[index]};
                    queue.add(temp);
                }
                index++;
            }
            while (!queue.isEmpty() && queue.peek()[1] <= day)
                queue.poll();
            if(!queue.isEmpty() && queue.peek()[1] > day){
                int[] poll = queue.poll();
                if(poll[0] > 1){
                    poll[0] -= 1;
                    queue.add(poll);
                }
                res++;
            }
            day++;
        }
        return res;
    }
}
