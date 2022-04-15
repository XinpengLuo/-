package 左神.数组和矩阵.刷题.矩阵中的幸运数;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                minRow[i] = Math.min(minRow[i],matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j],matrix[i][j]);
            }
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(minRow[i] == matrix[i][j] && maxCol[j] == matrix[i][j])
                    res.add(matrix[i][j]);
        return res;
    }
}
