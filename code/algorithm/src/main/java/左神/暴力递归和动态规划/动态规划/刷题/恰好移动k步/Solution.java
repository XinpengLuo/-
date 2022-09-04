package 左神.暴力递归和动态规划.动态规划.刷题.恰好移动k步;

import java.util.*;

public class Solution {
    HashMap<String,Long> map = new HashMap<>();
    public int numberOfWays(int startPos, int endPos, int k) {
        return (int) dfs(startPos,endPos,k);
    }

    public long dfs(int start, int end, int k){
        if(start == end && k == 0)
            return 1;
        if(Math.abs(start - end) > k)
            return 0;
        String key = "s:" + start + "k:" + k;
        if(map.containsKey(key))
            return map.get(key);
        long ans = 0;
        long left = 0, right = 0;
        String leftKey = "s:" + (start - 1) + "k:" + (k - 1);
        String rightKey = "s:" + (start + 1) + "k:" + (k - 1);
        if(!map.containsKey(leftKey))
            map.put(leftKey,dfs(start - 1,end,k - 1));
        left = map.get(leftKey);
        if(!map.containsKey(rightKey))
            map.put(rightKey,dfs(start + 1,end,k - 1));
        right = map.get(rightKey);
        map.put(key,(left + right) % 1000000007);
        return map.get(key);
    }
}
