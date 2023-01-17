package 主要练习.暴力递归和动态规划.递归和回溯.刷题.矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(help(board,word.toCharArray(),flag,"",j,i,0))
                    return true;
            }
        }
        return false;
    }
    public boolean help(char[][] board, char[] word, boolean[][] flag, String temp, int col, int row,int index){
        if(index == word.length)
            return true;
        if(col < 0 || col >= board[0].length || row < 0 || row >= board.length || flag[row][col] || word[index] != board[row][col])
            return false;
        flag[row][col] = true;
        boolean res = false;
        res = res || help(board,word,flag,temp + board[row][col],col,row - 1,index + 1);
        res = res || help(board,word,flag,temp + board[row][col],col,row + 1,index + 1);
        res = res || help(board,word,flag,temp + board[row][col],col - 1,row,index + 1);
        res = res || help(board,word,flag,temp + board[row][col],col + 1,row,index + 1);
        flag[row][col] = false;
        return res;
    }
}
