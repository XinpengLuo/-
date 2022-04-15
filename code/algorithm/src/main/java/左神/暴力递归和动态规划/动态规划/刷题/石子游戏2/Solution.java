package 左神.暴力递归和动态规划.动态规划.刷题.石子游戏2;

import javax.print.DocFlavor;
import java.sql.SQLOutput;

public class Solution {
    public int stoneGameII(int[] piles) {
        return first(piles,0,1);
    }
    //两个递归函数分别表示 先手拿到的 和 后手拿到的
    public int first(int[] piles, int index, int M){
        int res = 0;
        if(piles.length - index - 1 <= 2 * M){
            for(int cur = index; cur < piles.length; cur ++){
                res += piles[cur];
            }
            return res;
        }
        int count = 0;
        for(int x = 1; index + x  <= piles.length && x <= 2 * M; x ++){
            count += piles[index + x - 1];
            res = Math.max(res,second(piles, x + index, Math.max(x, M)) + count);
        }
        return res;
    }
    public int second(int[] piles, int index, int M){
        if(piles.length - index - 1 <= 2 * M){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int x = 1; x + index <= piles.length && x <= 2 * M; x ++){
            res = Math.min(res, first(piles, x + index, Math.max(x, M)));
        }
        return res;
    }
    public int dp(int[] piles){
        int n = piles.length;
        int[][] dpFirst = new int[n + 1][n + 1];
        int[][] dpSecond = new int[n + 1][n + 1];
        for(int i = 0; i < dpFirst.length; i++)
            for(int j = 0; j < dpFirst[i].length; j++){
                if(piles.length - i - 1 < 2 * j)
                    {for(int cur = i; cur < piles.length; cur++)
                        dpFirst[i][j] += piles[cur];
                     dpSecond[i][j] = 0;
                    }
            }
        for(int i = dpFirst.length - 1; i >= 0; i--)
            for(int j = 0; j < dpFirst[i].length; j++){
                if(piles.length - i - 1 >= 2 * j){
                    int count = 0;
                    for(int x = 1; i + x <= piles.length && x <= 2 *j; x++){
                        count += piles[i + x - 1];
                        dpFirst[i][j] = Math.max(dpFirst[i][j],dpSecond[x + i][Math.max(x,j)] + count);
                    }
                    dpSecond[i][j] = Integer.MAX_VALUE;
                    for(int x = 1; x + i <= piles.length && x <= 2 * j; x ++){
                        dpSecond[i][j] = Math.min(dpSecond[i][j], dpFirst[x + i][Math.max(x, j)]);
                    }
                }
            }
        return dpFirst[0][1];
    }
    public static void main(String[] args) {
        int[] arr = {2,7,9,4,21,4,4};
        Solution solution = new Solution();
        System.out.println(solution.stoneGameII(arr));
        System.out.println(solution.dp(arr));
    }
}
