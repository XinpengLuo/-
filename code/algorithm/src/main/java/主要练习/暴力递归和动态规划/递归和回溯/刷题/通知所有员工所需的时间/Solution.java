package 主要练习.暴力递归和动态规划.递归和回溯.刷题.通知所有员工所需的时间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < manager.length; i++){
            int boss = manager[i];
            if(!map.containsKey(boss))
                map.put(boss, new ArrayList<>());
            map.get(boss).add(i);
        }
        return help(map, informTime, headID);
    }
    public int help(HashMap<Integer,List<Integer>> map, int[] time, int boss){
        int max = 0;
        List<Integer> list = map.get(boss);
        if(list == null)
            return 0;
        for(int i = 0; i < list.size(); i++)
            max = Math.max(max, help(map, time, list.get(i)));
        return time[boss] + max;
    }

    public static void main(String[] args) {
        int[] a = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] b = {0,213,0,253,686,170,975,0,261,309,337};
        Solution solution = new Solution();
        System.out.println(solution.numOfMinutes(11, 4, a, b));
    }
}
