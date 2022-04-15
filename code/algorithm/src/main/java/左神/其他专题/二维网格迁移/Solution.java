package 左神.其他专题.二维网格迁移;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for (int t = 0; t < k; t++) {
            int[][] arr = new int[m][n];
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n; j++){
                    if(j == n - 1)
                        {
                            if(i + 1 >= m)
                                arr[0][0] = grid[i][n - 1];
                            else arr[i + 1][0] = grid[i][n - 1];
                        }
                    else if(i == m - 1 && j == n - 1)
                        arr[0][0] = grid[m - 1][n - 1];
                    else
                        {
                            if(j + 1 >= n)
                                arr[i][0] = grid[i][j];
                            else
                                arr[i][j + 1] = grid[i][j];;
                        }
                }
            grid = arr;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int[] itm : grid) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : itm) {
                temp.add(i);
            }
            list.add(temp);
        }
        return list;
    }
}
