package 主要练习.数组和矩阵.刷题.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int[] row = searchMatrixRow(matrix, target);
        if(row == null)
            return false;
        return searchMatrixCol(row,0,row.length - 1,target);
    }
    //确定行
    public int[] searchMatrixRow(int[][] matrix, int target){
        int[] arr = null;
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][matrix[0].length - 1] >= target){
                arr = matrix[i];
                break;
            }
        return arr;
    }

    //在行里二分查找
    public boolean searchMatrixCol(int[] arr, int left, int right, int target){
        if(left > right)
            return false;
        int middle = (left + right) / 2;
        if(arr[middle] == target)
            return true;
        else if (target > arr[middle])
            return searchMatrixCol(arr,middle + 1,right,target);
        else
            return searchMatrixCol(arr,left,middle - 1,target);
    }
}
