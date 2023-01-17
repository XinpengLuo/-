package 主要练习.暴力递归和动态规划.递归和回溯.刷题.网格中的最短路径;

public class Solution {
    public int shortestPath(int[][] grid, int k) {
        return dfs(grid,k,0,0);
    }
    public int dfs(int[][] grid, int k, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == -1)
            return 10000;
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return 0;
        if(grid[i][j] == 1){
            if(k == 0)
                return 10000;
            k--;
        }
        int pre = grid[i][j];
        grid[i][j] = -1;
        int top = dfs(grid,k,i - 1,j);
        int bottom = dfs(grid,k,i + 1,j);
        int left = dfs(grid,k,i,j - 1);
        int right = dfs(grid,k,i,j + 1);
        grid[i][j] = pre;
        int res = Integer.MAX_VALUE;
        res = Math.min(res,top);
        res = Math.min(res,left);
        res = Math.min(res,right);
        res = Math.min(res,bottom);
        if(res == 10000)
            return -1;
        return res + 1;
    }
}
