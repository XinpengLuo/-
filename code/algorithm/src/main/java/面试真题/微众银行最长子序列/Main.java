package 面试真题.微众银行最长子序列;

import java.util.*;

public class Main {
    static int[] arr;
    static long count = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        arr = new int[n];
        dfs(n,m,0);
        System.out.println(count);
    }
    public static void dfs(int n, int m, int index){
        if(n == index){
            if(check(arr))
                count = (count + 1) % 998244353;
            return;
        }
       for(int i = 1; i <= m; i++){
           arr[index] = i;
           dfs(n,m,index + 1);
       }
    }
    public static boolean check(int[] arr){
        int[] dp = new int[arr.length];
        int max = 1;
        dp[0] = 1;
        for(int i = 1; i < arr.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            if(dp[i] > 3)
                return false;
            max = Math.max(max,dp[i]);
        }
        return max == 3;
    }
}
