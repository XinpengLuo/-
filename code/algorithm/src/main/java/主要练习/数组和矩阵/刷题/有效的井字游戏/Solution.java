package 主要练习.数组和矩阵.刷题.有效的井字游戏;

public class Solution {
    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        boolean flagX = isWin(board,'X');
        boolean flagO = isWin(board,'O');
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'X')
                    countX++;
                else if(board[i].charAt(j) == 'O')
                    countO++;
            }
        if(countO != countX && countX - countO != 1)
            return false;
        if(flagX)
            return countX - countO == 1 && !flagO;
        if(flagO)
            return countX == countO && !flagX;
        return true;
    }
    public boolean isWin(String[] board, char c){
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
                return true;
            if(board[0].charAt(i) == c && board[1].charAt(i) == c &&  board[2].charAt(i) == c)
                return true;
        }
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test = {"OOO","XXO","XXX"};
        System.out.println(solution.validTicTacToe(test));
    }
}
