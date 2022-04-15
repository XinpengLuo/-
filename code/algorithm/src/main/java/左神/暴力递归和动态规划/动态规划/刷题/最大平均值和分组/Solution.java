package 左神.暴力递归和动态规划.动态规划.刷题.最大平均值和分组;

import java.util.Arrays;

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        return help(A,K,0);
    }
    public double help(int[] arr, int k, int left){
        if(k == 1){
            if(left < arr.length)
                return getAverage(arr,left,arr.length - 1);
            else
                return Double.MIN_VALUE;
        }
        double maxAveScore = Double.MIN_VALUE;
        for(int i = left; i < arr.length; i++)
            maxAveScore = Math.max(getAverage(arr,left,i) + help(arr,k - 1,i + 1) , maxAveScore);
        return maxAveScore;
    }
    public double dp(int[] A, int K){
        double[][] dp = new double[K + 1][A.length];
            for(int j = 0; j < A.length; j++){
                if(j >= A.length - K)
                    dp[1][j] = getAverage(A,j,A.length - 1);
                else
                    dp[1][j] = Double.MIN_VALUE;
            }



        for(int i = 2; i <= K; i++){
            double maxAveScore = Double.MIN_VALUE;
            for(int j = 0 ; j < A.length; j++)
               {
                   if(j < A.length - i - K)
                       {
                           dp[i][j] = maxAveScore;
                           continue;
                       }
                   for(int k = j; k < A.length; k++){
                        double a = k + 1 >= A.length ? Double.MIN_VALUE : dp[i - 1][k + 1];
                        maxAveScore = Math.max(getAverage(A,j,k) + a,maxAveScore);
                   }
                   dp[i][j] = maxAveScore;

               }

        }
        for (double[] t : dp) {
            System.out.println(Arrays.toString(t));
        }
        return dp[K][0];

    }
    public double getAverage(int[] arr, int left, int right){
        int sum = 0;
        for(int i = left; i <= right; i++)
            sum += arr[i];
        return (double)sum / (right - left + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9,1,2,3,9};
        System.out.println(solution.largestSumOfAverages(arr, 3));
        System.out.println(solution.dp(arr, 3));
    }
}
