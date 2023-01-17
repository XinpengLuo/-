package 主要练习.暴力递归和动态规划.动态规划.刷题.小球会落向何处;

import java.util.Arrays;

public class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans[i] = help(grid,0,i);
        }
        return ans;
    }
    public int help(int[][] grid, int rowIndex, int colIndex){
        if(colIndex < 0 || colIndex >= grid[0].length)
            return -1;
        if(rowIndex == grid.length)
            return colIndex;
        if(grid[rowIndex][colIndex] == 1 && (colIndex + 1 < grid[0].length && grid[rowIndex][colIndex + 1] == -1))
            return -1;
        if(grid[rowIndex][colIndex] == -1 && (colIndex - 1 >= 0 && grid[rowIndex][colIndex - 1] == 1))
            return -1;
        if(grid[rowIndex][colIndex] == 1)
            return help(grid,rowIndex + 1,colIndex + 1);
        else
            return help(grid,rowIndex + 1,colIndex - 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        Solution solution = new Solution();
        int[] ball = solution.findBall(arr);
        System.out.println(Arrays.toString(ball));

    }
}
