package 左神.数组和矩阵.刷题.搜索二维矩阵2;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix,target,0,matrix[0].length - 1);
    }
    public boolean searchMatrix(int[][] matrix, int target, int row, int col) {
        if(row >= matrix.length || col < 0)
            return false;
        if(target > matrix[row][col])
            return searchMatrix(matrix,target,row + 1, col);
        else if(target < matrix[row][col])
            return searchMatrix(matrix,target,row, col - 1);
        else
            return true;
    }
}
