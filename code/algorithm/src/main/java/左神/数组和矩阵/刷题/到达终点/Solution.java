package 左神.数组和矩阵.刷题.到达终点;

public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if(sx == tx && sy == ty)
                return true;
            if(tx > ty) {
                tx -= Math.max(((tx - sx) / ty),1) * ty;
            }
            else {
                ty -=  Math.max((ty - sy) / tx,1) * tx;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachingPoints(1, 1, 3, 5));
    }
}
