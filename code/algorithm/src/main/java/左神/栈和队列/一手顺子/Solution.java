package 左神.栈和队列.一手顺子;

import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            queue.add(hand[i]);
        }
        while (queue.size() > 0){
            int start = queue.poll();
            if(!map.containsKey(start))
                continue;
            map.put(start,map.get(start) - 1);
            if(map.get(start) == 0)
                map.remove(start);
            for(int i = 1; i < groupSize; i++){
                if(!map.containsKey(start + i))
                    return false;
                if(map.get(start + i) == 1)
                    map.remove(start + i);
                else
                    map.put(start + i,map.get(start + i) - 1);
            }
        }
        return true;
    }
}
