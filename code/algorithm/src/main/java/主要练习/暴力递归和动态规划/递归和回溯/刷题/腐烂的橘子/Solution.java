package 主要练习.暴力递归和动态规划.递归和回溯.刷题.腐烂的橘子;

import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0, round = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    int[] temp = new int[]{i,j};
                    queue.add(temp);
                }
                else if(grid[i][j] == 1)
                    count++;
            }
        while (!queue.isEmpty() && count > 0){
            int n = queue.size();
            round++;
            while (n-- > 0){
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];
                count -= help(x - 1,y,grid,queue);
                count -= help(x + 1,y,grid,queue);
                count -= help(x,y - 1,grid,queue);
                count -= help(x,y + 1,grid,queue);
            }
        }
        if(count != 0)
            return -1;
        return round;
    }
    public int help(int i, int j, int[][] grid, Queue<int[]> queue){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0)
            return 0;
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            queue.add(new int[]{i,j});
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(arr));
    }
}
