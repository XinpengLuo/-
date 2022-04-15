package 左神.数组和矩阵.刷题.有效的数独;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9]; //用于记录每一行 9个字符出现的次数
        int[][] col = new int[9][9]; //用于记录没一列 9个字符出现的次数
        int[][][] square = new int[3][3][9]; //用于记录每一个方块 9个字符出现的次数
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                char temp = board[i][j];
                if(temp != '.'){
                    int index = temp - '1';
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                    if(row[i][index] > 1 || col[j][index] > 1 || square[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        return true;
     }
}
