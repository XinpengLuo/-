package 左神.数组和矩阵.刷题.范围求和2;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int[] op : ops) {
            x = Math.min(op[0],x);
            y = Math.min(op[1],y);
        }
        return x * y;
    }
}
