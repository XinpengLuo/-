package 主要练习.暴力递归和动态规划.动态规划.刷题.俄罗斯套娃问题;

import java.util.Arrays;
import java.util.Comparator;

public class Solution{
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        return help(envelopes,0,envelopes.length);
    }
    public int help(int[][] envelopes, int index, int preIndex){
        if(index == envelopes.length)
            return 0;
        if(preIndex != envelopes.length){ //即有爸爸
            int res = help(envelopes, index + 1, preIndex);
            if(envelopes[index][0] > envelopes[preIndex][0] && envelopes[index][1] > envelopes[preIndex][1])
                res = Math.max(res, 1 + help(envelopes,index + 1, index));
            return res;
        }
        else
            return Math.max(1 + help(envelopes,index + 1, index),help(envelopes, index + 1, preIndex));
    }
    public int dp(int[][] envelopes){

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        int[][] dp = new int[envelopes.length + 1][envelopes.length + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j <= envelopes.length; j++){
                if(j != envelopes.length){
                    int res = dp[i + 1][j];
                    if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                        res = Math.max(res,1 + dp[i + 1][i]);
                    dp[i][j] = res;
                }
                else
                    dp[i][j] = Math.max(1 + dp[i + 1][i],dp[i + 1][j]);
            }
        return dp[0][envelopes.length];
    }
}
