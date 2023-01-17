package 面试真题.微软.零的片段数量;

import java.util.*;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        HashMap<Long,Long> map = new HashMap<>();
        map.put(0L, 1L);
        long sum = 0;
        long res = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            res += map.getOrDefault(sum,0L);
            map.put(sum,map.getOrDefault(sum,0L) + 1);
        }
        if(res > 1000000000)
            return -1;
        return (int) res;
    }
}
