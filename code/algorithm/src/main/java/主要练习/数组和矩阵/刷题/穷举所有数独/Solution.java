package 主要练习.数组和矩阵.刷题.穷举所有数独;

import java.util.ArrayList;

public class Solution {
    ArrayList<char[][]> res = new ArrayList<>();
    int count = 0;
    public void getAllSo(char[][] boards){
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] square = new int[3][3][9];
        dfs(boards,0,0,row,col,square);
    }
    public void dfs(char[][] boards, int i, int j, int[][] row, int[][] col, int[][][] square){
        while(boards[i][j] != '.'){
            j++;
            if(j == 9){
                i++;
                j = 0;
            }
            if(i == 9){
                printBoard(boards);
                return;
            }
        }
        for(char c = '1'; c <= '9'; c++){
            int temp = c - '1';
            boolean flag = false;
            if(row[i][temp] == 0 && col[j][temp] == 0 && square[i / 3][j / 3][temp] == 0){
                flag = true;
                boards[i][j] = c;
                row[i][temp]++;
                col[j][temp]++;
                square[i / 3][j / 3][temp]++;
                dfs(boards,i,j,row,col,square);
            }
            if(flag){
                boards[i][j] = '.';
                row[i][temp]--;
                col[j][temp]--;
                square[i / 3][j / 3][temp]--;
            }
        }
    }
    public void printBoard(char[][] boards){
        count++;
        System.out.println("第" + count + "种");
        System.out.println("--------");
        for (char[] board : boards) {
            System.out.println(String.valueOf(board));
        }
        System.out.println("----------");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        solution.getAllSo(board);
    }
}
