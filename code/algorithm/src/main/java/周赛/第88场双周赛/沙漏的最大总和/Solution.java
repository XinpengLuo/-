package 周赛.第88场双周赛.沙漏的最大总和;

public class Solution {
    int max = 0;
    public int maxSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                getVal(grid,i,j);
        return max;
    }
    public void getVal(int[][] grid, int i, int j){
        if(i + 2 >= grid.length || j + 2 >= grid[0].length)
            return;
        int val = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
                 + grid[i + 1][j + 1]
                + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        max = Math.max(val,max);
    }
}
