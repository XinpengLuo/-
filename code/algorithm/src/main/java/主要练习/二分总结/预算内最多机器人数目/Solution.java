package 主要练习.二分总结.预算内最多机器人数目;

import java.util.*;

public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int res = 0;
        int left = 0, right = chargeTimes.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int j = 0;
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            long sum = 0;
            boolean flag = false;
            for(int i = 0; i < chargeTimes.length; i++){
                treeMap.put(chargeTimes[i],treeMap.getOrDefault(chargeTimes[i],0) + 1);
                sum += runningCosts[i];
                if(i >= mid - 1){
                    long temp = treeMap.lastKey() + mid * sum;
                    if(temp <= budget){
                        flag = true;
                        break;
                    }
                    if(treeMap.get(chargeTimes[j]) == 1)
                        treeMap.remove(chargeTimes[j]);
                    else
                        treeMap.put(chargeTimes[j],treeMap.get(chargeTimes[j]) - 1);
                    sum -= runningCosts[j];
                    j++;
                }
            }
            if(flag){
                res = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return res;
    }
}
