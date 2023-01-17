package 主要练习.数组和矩阵.刷题.保持城市天际线;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] maxRow = new int[r];
        int[] maxCol = new int[c];
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++){
                maxRow[i] = Math.max(maxRow[i],grid[i][j]);
                maxCol[j] = Math.max(maxCol[j],grid[i][j]);
            }
        int ans = 0;
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                ans += Math.min(maxRow[i],maxCol[j]) - grid[i][j];
        return ans;
    }
}
