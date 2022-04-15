package 左神.暴力递归和动态规划.递归和回溯.刷题.二维数组查找;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return help(matrix,target,0,matrix[0].length - 1);
    }
    public boolean help(int[][] arr, int target, int i, int j){
        if(i >= arr.length || j < 0)
            return false;
        if(arr[i][j] == target)
            return true;
        else if(arr[i][j] < target)
            return help(arr,target, i + 1, j);
        else
            return help(arr,target,i, j - 1);
    }
}
