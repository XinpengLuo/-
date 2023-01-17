package 主要练习.暴力递归和动态规划.动态规划.刷题.矩阵中最长递增路径;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(matrix));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[][] memo = new int[matrix.length][matrix[0].length];
                res = Math.max(res,help(i,j,matrix,-1,memo));
            }
        }
        return res;
    }

    public int help(int row, int col, int[][] matrix, int preValue, int[][] memo){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= preValue)
            return 0;
        if(memo[row][col] != 0)
            return memo[row][col];
        int res = Integer.MIN_VALUE;
        res = Math.max(res, help(row + 1, col, matrix,matrix[row][col],memo));
        res = Math.max(res, help(row, col + 1, matrix,matrix[row][col],memo));
        res = Math.max(res, help(row - 1, col, matrix,matrix[row][col],memo));
        res = Math.max(res, help(row, col - 1, matrix,matrix[row][col],memo));
        memo[row][col] = res + 1;
        return res + 1;
    }

}
