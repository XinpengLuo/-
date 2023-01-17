package 主要练习.暴力递归和动态规划.动态规划.刷题.网格中的最短路径;

public class Solution {
    int minPath = Integer.MAX_VALUE;
    public int shortestPath(int[][] grid, int k) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        help(grid,k,0,0,0,flag);
        if(minPath == Integer.MAX_VALUE)
            return -1;
        return minPath;
    }
    public void help(int[][] arr, int k, int i, int j, int tempPath,boolean[][] flag){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || k == -1 || flag[i][j])
            return;
        if(i == arr.length - 1 && j == arr[0].length - 1){
            minPath = Math.min(tempPath,minPath);
            return;
        }
        flag[i][j] = true;
        if(arr[i][j] == 1)
            k--;
        help(arr,k,i + 1,j,tempPath + 1,flag);
        help(arr,k,i - 1,j,tempPath + 1,flag);
        help(arr,k,i,j + 1,tempPath + 1,flag);
        help(arr,k,i,j - 1,tempPath + 1,flag);
        flag[i][j] = false;
    }
}
