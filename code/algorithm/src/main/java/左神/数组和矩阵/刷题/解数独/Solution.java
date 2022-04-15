package 左神.数组和矩阵.刷题.解数独;

import java.util.Arrays;

public class Solution {
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][][] square = new int[3][3][9];
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                }
        dfs(board,0,0);
    }
    public boolean dfs(char[][] board, int i, int j){
        while (board[i][j] != '.'){
            j++;
            if(j == 9){
                i++;
                j = 0;
            }
            if(i == 9)
                return true;
        }

            for(char num = '1'; num <= '9'; num++){
                int index = num - '1';
                if(row[i][index] == 0 && col[j][index] == 0 && square[i / 3][j / 3][index] == 0){
                    row[i][index]++;
                    col[j][index]++;
                    square[i / 3][j / 3][index]++;
                    board[i][j] = num;
                    if(dfs(board, i , j))
                        return true;
                    else{
                        board[i][j] = '.';
                        row[i][index]--;
                        col[j][index]--;
                        square[i / 3][j / 3][index]--;
                    }
                }
            }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'.', '6', '5', '2', '.', '.', '4', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '1', '.', '.'},
                {'.', '2', '.', '4', '.', '.', '.', '.', '8'},
                {'.', '.', '.', '.', '.', '.', '.', '1', '.'},
                {'.', '.', '.', '5', '9', '.', '6', '.', '7'},
                {'.', '.', '.', '3', '.', '.', '.', '5', '.'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'5', '.', '1', '.', '.', '.', '.', '2', '.'},
                {'.', '4', '3', '.', '.', '.', '.', '.', '.'}
        };
        solution.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(String.valueOf(chars));
        }
    }
}
