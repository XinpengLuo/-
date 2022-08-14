package 面试真题.微软.排放;

import java.util.*;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java 11 (Java SE 11)
        int count = 0;
        double sum = 0;
        TreeMap<Double,Integer> map = new TreeMap<>();
        for (int i : A) {
            sum += i;
            if(i != 0){
                map.put((double) i,map.getOrDefault((double) i,0) + 1);
            }
        }
        if(sum == 0)
            return 0;
        double target = sum / 2;
        while(sum > target){
            Double last = map.lastKey();
            if(map.get(last) == 1)
                map.remove(last);
            else
                map.put(last,map.get(last) - 1);
            map.put(last / 2, map.getOrDefault(last / 2,0) + 1);
            sum -= last / 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //4 2.5 + 1.5
        int[] arr = {3,0,5,7};
        System.out.println(solution.solution(arr));
    }
}
