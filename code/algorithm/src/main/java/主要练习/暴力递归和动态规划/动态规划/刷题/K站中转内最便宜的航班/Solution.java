package 主要练习.暴力递归和动态规划.动态规划.刷题.K站中转内最便宜的航班;

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int money = getMinMoney(k, flights, src, dst);
        return money == 100007 ? -1 : money;
    }


    public static void main(String[] args) {
        int[][] flights = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,1},{0,4,2},{7,2,8}};
        int[][] flightsTwo = {{0,1,100},{1,2,100},{0,2,50}};
        Solution solution = new Solution();
//        System.out.println(solution.findCheapestPrice(10, flights, 6, 0, 7));
//        System.out.println(solution.dp(10, 7, flights, 6, 0));
        solution.dfs(4,flightsTwo,0,3,1);
    }
    public int dp(int n, int k, int[][] flights,int src, int dst){
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < dp.length; i++) {
            if(i == dst)
                dp[i][0] = 0;
            else{
                dp[i][0] = 100007;
                for (int[] flight : flights) {
                    if(flight[0] == i && flight[1] == dst)
                        dp[i][0] = flight[2];
                }
            }
        }
        if(k > 0){
            for(int j = 1; j <= k; j++)
                for(int i = 0; i < dp.length; i++){
                    if(i != dst)
                    {int minMoney = 100007;
                    for (int[] flight : flights) {
                        if(flight[0] == i)
                            minMoney = Math.min(minMoney,flight[2] + dp[flight[1]][j - 1]);
                    }

                    dp[i][j] = minMoney;}
                }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[src][k] == 100007 ? -1 : dp[src][k];
    }
    public int getMinMoney(int k, int[][] flights, int src, int dst){
        if(src == dst)
            return 0;
        if(k < 0)
            return 100007;
        int minMoney = 100007;
        for (int[] flight : flights) {
            if(flight[0] == src)
                minMoney = Math.min(minMoney,flight[2] + getMinMoney(k - 1,flights,flight[1],dst));
        }
        return minMoney;
    }



    public int dfs(int n, int[][] flights, int src, int dst, int k){
        if(src == dst)
            return 0;
        if(k == 0)
            return 10000;
        int res = 10000;
        for(int i = 0; i < flights.length; i++){
            int[] temp = flights[i];
            if(temp[0] == src)
                res = Math.min(res, temp[2] + dfs(n,flights,temp[1],dst,k - 1));
        }
        return res;
    }
}
