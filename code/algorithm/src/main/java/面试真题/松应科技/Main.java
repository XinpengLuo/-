package 面试真题.松应科技;

import java.util.*;

public class Main {

    public int MLS (int[] arr) {
        // write code here
       return dp(arr);
    }
    public int dp(int[] arr){
       int[] dp = new int[arr.length];
       dp[0] = 1;
       int max = 1;
       for(int i = 1; i < dp.length; i++) {
           for (int j = 0; j < i; j++) {
               if (arr[j] + 1 == arr[i])
                   dp[i] = Math.max(dp[j] + 1, dp[i]);
           }
           max = Math.max(max,dp[i]);
       }
       return max;
    }
}
