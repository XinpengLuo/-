package 主要练习.暴力递归和动态规划.动态规划.刷题.堆箱子;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int pileBox(int[][] box) {
        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        return help(box,0,box.length);
    }
    public int help(int[][] box, int index, int preIndex){
         if(index == box.length)
             return 0;
         if(preIndex != box.length){
             int res = help(box,index + 1,preIndex);
             if(box[index][0] > box[preIndex][0] && box[index][1] > box[preIndex][1] && box[index][2] > box[preIndex][2])
                 res = Math.max(res,box[index][2] + help(box,index + 1,index));
             return res;
         }
         else
             return Math.max(box[index][2] + help(box,index + 1,index),help(box,index + 1,preIndex));
    }
    public int dp(int[][] box){
        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        int[][] dp = new int[box.length + 1][box.length + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j <= box.length; j++){
                if(j != box.length){
                    int res = dp[i + 1][j];
                    if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2])
                        {

                            res = Math.max(res,box[i][2] + dp[i + 1][i]);
                        }
                    dp[i][j] = res;
                }
                else
                    dp[i][j] = Math.max(box[i][2] + dp[i + 1][i],dp[i + 1][j]);
            }
        return dp[0][box.length];
    }
    public static void main(String[] args) {
        int[][] box = {{41,1,1},{3,2,2},{3,3,3}};
        Solution solution = new Solution();
        System.out.println(solution.pileBox(box));
        System.out.println(solution.dp(box));
    }
}
