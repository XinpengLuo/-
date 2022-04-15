package 左神.暴力递归和动态规划.递归和回溯.刷题.黄金矿工;

public class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res,getMaximumGold(grid,flag,i,j));
            }
        }
        return res;
    }
    public int getMaximumGold(int[][] grid, boolean[][] flag, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || flag[row][col])
            return 0;
        flag[row][col] = true;
        int res = Integer.MIN_VALUE;
        res = Math.max(res,getMaximumGold(grid,flag,row - 1,col));
        res = Math.max(res,getMaximumGold(grid,flag,row + 1,col));
        res = Math.max(res,getMaximumGold(grid,flag,row,col - 1));
        res = Math.max(res,getMaximumGold(grid,flag,row,col + 1));
        flag[row][col] = false;
        return res + grid[row][col];
    }
}
