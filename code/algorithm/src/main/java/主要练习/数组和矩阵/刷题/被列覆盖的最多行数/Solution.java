package 主要练习.数组和矩阵.刷题.被列覆盖的最多行数;

import java.util.*;

public class Solution {
    int max = 0;
    public int maximumRows(int[][] mat, int cols) {
        dfs(mat,cols,mat[0].length,0,new HashSet<>());
        return max;
    }
    public void dfs(int[][] mat, int cols, int m, int index, HashSet<Integer> set){
        if(index == m){
            if(cols != 0)
                return;
            max = Math.max(max,check(mat,set));
            return;
        }
        dfs(mat,cols,m,index + 1,set);
        set.add(index);
        dfs(mat,cols - 1,m,index + 1,set);
        set.remove(index);
    }
    public int check(int[][] mat, HashSet<Integer> set){
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            boolean flag = true;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1 && !set.contains(j)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                res++;
        }
        return res;
    }
}
