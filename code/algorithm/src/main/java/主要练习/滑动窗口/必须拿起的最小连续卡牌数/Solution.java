package 主要练习.滑动窗口.必须拿起的最小连续卡牌数;

import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for(int i = 0; i < cards.length; i++){
            if(map.containsKey(cards[i])) {
                res = res == -1 ? i - map.get(cards[i]) + 1 : Math.min(res, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i],i);
        }
        return res;
    }
}