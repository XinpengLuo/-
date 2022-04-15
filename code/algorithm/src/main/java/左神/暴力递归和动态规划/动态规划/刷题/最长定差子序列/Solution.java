package 左神.暴力递归和动态规划.动态规划.刷题.最长定差子序列;

import java.util.HashMap;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        return help(arr,0,difference,-1);
    }
    public int help(int[] arr, int index, int difference, int preIndex){
        if(index == arr.length)
            return 0;
        if(preIndex == -1 || arr[preIndex] + difference == arr[index])
            return Math.max(1 + help(arr,index + 1,difference,index),help(arr,index + 1,difference,preIndex)) ;
        return help(arr,index + 1,difference,preIndex);
    }
    public int dp(int[] arr, int difference){
        int[] dp = new int[arr.length];
        int ans = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++)
                if(arr[j] + difference == arr[i])
                    dp[i] = Math.abs(dp[j] + 1);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int newDp(int[] arr, int difference){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 1;
        for(int i = 0; i < arr.length; i++){
            if(hashMap.containsKey(arr[i] - difference)){
                hashMap.put(arr[i],hashMap.get(arr[i] - difference) + 1);
                ans = Math.max(hashMap.get(arr[i]),ans);
            }
            else
                hashMap.put(arr[i],1);
        }
        return ans;
    }
    public int newDpNewHash(int[] arr, int difference){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 1;
        for(int i = 0; i < arr.length; i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i] - difference,0) + 1);
            ans = Math.max(hashMap.get(arr[i]),ans);
        }
        return ans;
    }
}
