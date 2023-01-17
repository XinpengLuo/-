package 主要练习.暴力递归和动态规划.递归和回溯.刷题.单词搜索;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                if(help(board,word,i,j,0))
                    return true;
        }
        return false;
    }
    public boolean help(char[][] board, String word, int r, int c, int index){
        if(index == word.length())
            return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index) || board[r][c] == '1')
            return false;
        char temp = board[r][c];
        board[r][c] = '1';
        boolean res = help(board,word,r + 1,c,index + 1) || help(board,word,r - 1,c,index + 1)
                || help(board,word,r,c + 1,index + 1) || help(board,word,r,c - 1,index + 1);
        board[r][c] = temp;
        return res;
    }

}
