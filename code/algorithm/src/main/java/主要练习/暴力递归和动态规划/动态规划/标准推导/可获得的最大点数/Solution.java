package 主要练习.暴力递归和动态规划.动态规划.标准推导.可获得的最大点数;

import java.util.Arrays;

public class Solution {
    //递归版本
    public int maxScore(int[] cardPoints, int k) {
        return excellentHelp(cardPoints,k,0,cardPoints.length - 1);
    }
    public int excellentHelp(int[] carPoints,int k, int i, int j){
        if(k == 0)
            return 0;
        return Math.max(
                carPoints[i] + excellentHelp(carPoints,k - 1, i + 1,j),
                   carPoints[j] + excellentHelp(carPoints, k - 1, i, j - 1)
                );
    }
    //动态规划版本
    public int dp(int[] carPoints, int k, int i, int j){
        int[][][] dp = new int[j + 1][j + 1][k + 1]; //因为如果数组长度为k 不能取到a[k]
        for(int left = 0; left < j + 1; left++)
            for(int right = 0; right < j + 1; right++)
                dp[i][j][0] = 0;
        for(int time = 1; time < k + 1; time++)
            for(int left = 0; left < j + 1; left++)
                for(int right = 0; right < j + 1; right++){
                    int a = left + 1 >= j + 1 ? 0 : dp[left + 1][right][time - 1];
                    int b = right - 1 < 0 ? 0 : dp[left][right - 1][time - 1];
                    dp[left][right][time] = Math.max(carPoints[left] + a, carPoints[right] + b);
                }
        return dp[0][j][k];
    }
    //滑动窗口版本
    public int slideWindow(int[] cardPoints, int k){
        int length = cardPoints.length - k; //滑动窗口的大小
        int minSum = 0;
        for(int i = 0; i < length; i++)
            minSum += cardPoints[i];
        int sum = minSum;
        for(int i = length; i < cardPoints.length; i++){
            sum = sum + cardPoints[i] - cardPoints[i - length];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,1};
        System.out.println(solution.maxScore(arr, 3));
        System.out.println(solution.excellentHelp(arr, 3,0,arr.length - 1));
        System.out.println(solution.dp(arr, 3, 0, arr.length - 1));
        System.out.println(solution.slideWindow(arr,3));
    }
}
