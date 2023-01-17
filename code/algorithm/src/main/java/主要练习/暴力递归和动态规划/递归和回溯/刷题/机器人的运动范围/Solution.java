package 主要练习.暴力递归和动态规划.递归和回溯.刷题.机器人的运动范围;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] falg = new boolean[m][n];
        return help(0,0,falg,k);
    }
    public int help(int i, int j,boolean[][] flag, int k){
        if(i < 0 || i >= flag.length || j < 0 || j >= flag[0].length || (i / 10 + i % 10 + j / 10 + j % 10) > k || flag[i][j])
            return 0;
        flag[i][j] = true;
        return 1 + help(i + 1, j,flag,k) + help(i - 1,j,flag,k) + help(i,j - 1,flag,k) + help(i,j + 1,flag,k);
    }
}
