package 主要练习.暴力递归和动态规划.递归和回溯.刷题.甲板上的战舰;

public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == '*'){
                    for(int k = i; k < n && board[k][j] == '.'; k++)
                        board[k][j] = '.';
                    for(int k = j; k < m && board[i][k] == '.'; k++)
                        board[i][k] = ',';
                    count++;
                }
            }
        return count;
    }
}
