package 主要练习.暴力递归和动态规划.递归和回溯.刷题.飞地的数量;

public class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int j = 0; j < grid[0].length; j++){
            dfs(grid,0,j);
            dfs(grid,grid.length - 1,j);
        }
        for(int i = 0; i < grid.length; i++){
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length - 1);
        }
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                if(grid[i][j] == 1)
                    count++;
        return count;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == 2)
            return;
        grid[i][j] = 2;
        dfs(grid,i - 1, j);
        dfs(grid,i + 1, j);
        dfs(grid,i, j - 1);
        dfs(grid,i , j + 1);
    }
}
