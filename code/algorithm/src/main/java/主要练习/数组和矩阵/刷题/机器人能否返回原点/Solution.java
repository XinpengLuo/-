package 主要练习.数组和矩阵.刷题.机器人能否返回原点;

public class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < moves.toCharArray().length; i++) {
            if(moves.charAt(i) == 'U')
                u++;
            else if(moves.charAt(i) == 'D')
                d++;
            else if(moves.charAt(i) == 'L')
                l++;
            else if(moves.charAt(i) == 'R')
                r++;
        }
        if(u - d == 0 && r - l == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("LL"));
    }
}
