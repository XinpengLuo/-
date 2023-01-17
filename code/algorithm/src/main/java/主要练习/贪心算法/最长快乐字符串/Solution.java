package 主要练习.贪心算法.最长快乐字符串;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0] - t1[0];
            }
        });
        if(a > 0)
            queue.add(new int[]{a,0});
        if(b > 0)
            queue.add(new int[]{b,1});
        if(c > 0)
            queue.add(new int[]{c,2});
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int len = sb.length();
            if(len >= 2 && sb.charAt(len - 1) - 'a' == cur[1] && sb.charAt(len - 2) - 'a' == cur[1]){
                if(queue.isEmpty())
                    break;
                int[] temp = queue.poll();
                sb.append((char)('a' + temp[1]));
                if(--temp[0] > 0)
                    queue.add(temp);
                queue.add(cur);
            }
            else{
                sb.append((char)('a' + cur[1]));
                if(--cur[0] > 0)
                    queue.add(cur);
            }
        }
        return sb.toString();
    }
}
