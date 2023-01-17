package 主要练习.暴力递归和动态规划.递归和回溯.刷题.有效的数独;

public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++)
//        }
//        for(int i = 0; i < 3; i++)
//            for(int j = 0; j < 3; j++){
//
//            }
//    }
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        String[] arr = s.split("");
        return arr[arr.length - 1].length();

    }
}
