package 左神.暴力递归和动态规划.递归和回溯.刷题.被围绕的区域;

import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O')
                dfs(board,0,i);
            if(board[board.length - 1][i] == 'O')
                dfs(board,board.length - 1,i);
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O')
                dfs(board,i,0);
            if(board[i][board[i].length - 1] == 'O')
                dfs(board,i,board[i].length - 1);
        }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '1')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == '1')
            return;
        board[i][j] = '1';
        dfs(board,i - 1,j);
        dfs(board,i + 1,j);
        dfs(board,i,j - 1);
        dfs(board,i,j + 1);
    }

    public static void main(String[] args) {
        char[][] arr = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        Solution solution = new Solution();
        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }
        solution.solve(arr);
        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
