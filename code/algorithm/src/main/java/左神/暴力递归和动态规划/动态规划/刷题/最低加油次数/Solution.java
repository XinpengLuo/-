package 左神.暴力递归和动态规划.动态规划.刷题.最低加油次数;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return dfs(target,stations,startFuel,0);
    }
    public int dfs(int target, int[][] stations, int temp, int index){
        if(temp >= target)
            return 0;
        int res = Integer.MAX_VALUE;
        for(int i = index; i < stations.length && temp >= stations[i][0]; i++)
        {
            int num = dfs(target,stations,temp + stations[i][1],i + 1);
            if(num != -1)
                res = Math.min(res,1 + num);
        }

        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    public int better(int target, int[][] stations, int startFuel){
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int start = startFuel;
        int res = 0;
        int i = 0;
        while (start < target){
            if(i < stations.length && start >= stations[i][0]){
                heap.add(stations[i][1]);
                i++;
            }
            else{
                if(!heap.isEmpty()){
                    start += heap.poll();
                    res++;
                }
                else
                    return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(100, 10, stations));
    }
}
