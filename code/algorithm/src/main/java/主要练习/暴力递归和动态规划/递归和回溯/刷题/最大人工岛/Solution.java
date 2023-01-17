package 主要练习.暴力递归和动态规划.递归和回溯.刷题.最大人工岛;

import java.util.*;

public class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int largestIsland(int[][] grid) {
        int nexNum = 2;
        int max = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int temp = dfs(grid,i,j,nexNum);
                    map.put(nexNum,temp);
                    max = Math.max(max,temp);
                    nexNum++;
                }
            }
        if(max == grid.length * grid[0].length)
            return max;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    if(i - 1 >= 0)
                        set.add(grid[i - 1][j]);
                    if(i + 1 < grid.length)
                        set.add(grid[i + 1][j]);
                    if(j - 1 >= 0)
                        set.add(grid[i][j - 1]);
                    if(j + 1 < grid[0].length)
                        set.add(grid[i][j + 1]);
                    int temp = 1;
                    for (Integer integer : set) {
                        temp += map.getOrDefault(integer,0);
                    }
                    max = Math.max(max,temp);
                }
            }
        return max;
    }
    public int dfs(int[][] grid, int i, int j, int nextNum){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = nextNum;
        return dfs(grid,i + 1,j ,nextNum) +
               dfs(grid,i - 1,j, nextNum) +
               dfs(grid,i,j - 1, nextNum) +
               dfs(grid,i,j + 1, nextNum) +
                1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{1,1}};
        Solution solution = new Solution();
        System.out.println(solution.largestIsland(arr));
    }
}
