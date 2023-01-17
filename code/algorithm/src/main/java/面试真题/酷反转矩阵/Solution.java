package 面试真题.酷反转矩阵;

import 面试真题.快手栈.Main;

import java.util.*;

public class Solution {
    public static char[][] Flick(char[][] matrix) {
        //请在这里实现算法并返回翻转后的结果
        //char[][] result = new char[matrix.length][matrix[0].length];
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 'O')
                dfs(i,0,matrix);
            if(matrix[i][n - 1] == 'O')
                dfs(i,n - 1,matrix);
        }
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 'O')
                dfs(0,i,matrix);
            if(matrix[m - 1][i] == 'O')
                dfs(m - 1,i,matrix);
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1')
                    matrix[i][j] = 'O';
                else if(matrix[i][j] == 'O')
                    matrix[i][j] = 'X';
            }
        return matrix;
    }
    public static void dfs(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '1')
            return;
        board[i][j] = '1';
        dfs(i + 1,j,board);
        dfs(i - 1,j,board);
        dfs(i,j + 1,board);
        dfs(i,j - 1,board);
    }
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
       TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : count) {
            if(i == 0)
                continue;
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        if(map.size() == 1)
        {
            if(map.firstKey() == 1 || map.get(map.firstKey()) == 1)
                return true;
            return false;
        }
        if(map.size() >= 3)
            return false;
        if(map.lastKey() - map.firstKey() == 1 && (map.get(map.firstKey()) == 1 ||map.get(map.lastKey()) == 1))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "cccaa";
        Solution solution = new Solution();
        System.out.println(solution.equalFrequency(s));
    }
}
