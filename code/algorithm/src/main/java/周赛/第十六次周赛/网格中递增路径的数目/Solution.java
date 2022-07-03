package 周赛.第十六次周赛.网格中递增路径的数目;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Solution {
    int mod = 1000000007;
    HashMap<Integer,HashMap<Integer,Long>> map = new HashMap<>();
    public int countPaths(int[][] grid) {
        Arrays.sort(grid, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return 0;
            }
        });
        long res = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                {
                    long temp = dfs(grid,i,j) % mod;
                    res = (res + dfs(grid,i,j)) % mod;
                }
        return (int)res;
    }
    public long dfs(int[][] grid, int i, int j){
        int val = grid[i][j];
        grid[i][j] = 0;
        long top = 0;
        long bottom = 0;
        long left = 0;
        long right = 0;
        if(i - 1 >= 0 && grid[i - 1][j] != 0 && val < grid[i - 1][j])
            {
                if(map.containsKey(i - 1) && map.get(i - 1).containsKey(j))
                    top = map.get(i - 1).get(j);
                else{
                    top = dfs(grid,i - 1,j);
                    if(!map.containsKey(i - 1))
                        map.put(i - 1, new HashMap<>());
                    map.get(i - 1).put(j,top);
                }
            }
        if(i + 1 < grid.length && grid[i + 1][j] != 0 && val < grid[i + 1][j])
            {
                if(map.containsKey(i + 1) && map.get(i + 1).containsKey(j))
                    bottom = map.get(i + 1).get(j);
                else{
                    bottom = dfs(grid,i + 1,j);
                    if(!map.containsKey(i + 1))
                        map.put(i + 1, new HashMap<>());
                    map.get(i + 1).put(j,bottom);
                }
            }
        if(j - 1 >= 0 && grid[i][j - 1] != 0 && val < grid[i][j - 1])
            {
                if(map.containsKey(i) && map.get(i).containsKey(j - 1))
                    left = map.get(i).get(j - 1);
                else{
                    left = dfs(grid,i,j - 1);
                    if(!map.containsKey(i))
                        map.put(i, new HashMap<>());
                    map.get(i).put(j - 1,left);
                }
            }
        if(j + 1 < grid[0].length && grid[i][j + 1] != 0 && val < grid[i][j + 1])
        {
            if(map.containsKey(i) && map.get(i).containsKey(j + 1))
                right = map.get(i).get(j + 1);
            else{
                right = dfs(grid,i,j + 1);
                if(!map.containsKey(i))
                    map.put(i, new HashMap<>());
                map.get(i).put(j + 1,right);
            }
        }

        grid[i][j] = val;
        long res = (top + bottom + left + right + 1) % mod;
        if(!map.containsKey(i))
            map.put(i, new HashMap<>());
        map.get(i).put(j,res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        Arrays.sort(arr);
        int index = arr.length - 1;
        while(true){
            while(!queue.isEmpty() && queue.peek() <= time)
                queue.poll();
            while(index >= 0  && queue.size() < 2){
                queue.add(time + arr[index]);
                index--;
            }
            if(queue.isEmpty())
                break;
            time = queue.peek();
        }
        System.out.println(time);
    }
}
