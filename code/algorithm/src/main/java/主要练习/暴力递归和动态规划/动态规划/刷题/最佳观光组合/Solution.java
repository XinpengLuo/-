package 主要练习.暴力递归和动态规划.动态规划.刷题.最佳观光组合;

public class Solution {
    public int maxScoreSightseeingPair(int[] values){
        int ans = Integer.MIN_VALUE, preMaxI = 0;
        for (int i = 0; i < values.length; i++) {
            int jValue = values[i] - i;
            ans = Math.max(ans,jValue + preMaxI);
            preMaxI = Math.max(preMaxI,values[i] + i);
        }
        return ans;
    }

}
