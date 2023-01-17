package 面试真题.粒子实验;

import java.util.*;
public class Main{
    public static void main(String[] args){

//        1 2 3 4 5 6 7
//        6 5 3 7 2 1 4
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            int start = scanner.nextInt();
            map.put(start,i);
        }
        int temp = 0;
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            int end = scanner.nextInt();
            int startIndex = map.get(end);
            if(i != startIndex)
                temp++;
        }
        System.out.println(temp / 2);
//        System.out.println(res);
    }
    // 5
// 1 2 3 4 5     1 2 3 4 5   1 2 3 4 5
// 1 5 3 4 2     5 4 3 2 1   2 3 4 5 1
// 3
    public static int dp(int[] a, int[] b){
        int[][] dp = new int[a.length + 1][b.length + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = dp[i].length - 2; j >= 0; j--){
                if(a[i] == b[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        return dp[0][0];
    }
}