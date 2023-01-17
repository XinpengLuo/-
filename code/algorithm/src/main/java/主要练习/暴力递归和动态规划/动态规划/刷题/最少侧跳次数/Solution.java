package 主要练习.暴力递归和动态规划.动态规划.刷题.最少侧跳次数;

public class Solution {
    public int minSideJumps(int[] obstacles) {
        return help(0,2,obstacles);
    }
    public int help(int index, int way, int[] obstacles){
        if(index == obstacles.length - 1)
            return 0;
        if(obstacles[index] == way)
            return Integer.MAX_VALUE - 1;
        int res = Integer.MAX_VALUE;
        if(way == 1){
            if(obstacles[index] != 2)
                res = Math.min(1 + help(index + 1,2,obstacles),help(index + 1,1,obstacles));
            if(obstacles[index] != 3)
                res = Math.min(res,Math.min(1 + help(index + 1,3,obstacles),help(index + 1,1,obstacles)));
        }
        else if(way == 2){
            if(obstacles[index] != 1)
                res = Math.min(help(index + 1,2,obstacles),1 + help(index + 1,1,obstacles));
            if(obstacles[index] != 3)
                res = Math.min(res,Math.min(1 + help(index + 1,3,obstacles),help(index + 1,2,obstacles)));
        }
        else{
            if(obstacles[index] != 1)
                res = Math.min(help(index + 1,3,obstacles),1 + help(index + 1,1,obstacles));
            if(obstacles[index] != 2)
                res = Math.min(res,Math.min(1 + help(index + 1,2,obstacles),help(index + 1,3,obstacles)));
        }
        return res;
    }
    public int dp(int[] obstacles){
        int[][] dp = new int[obstacles.length][3];
        for(int i = 0; i < 3; i++)
            dp[obstacles.length - 1][i] = 0;

        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < 3; j++){
                if(obstacles[i] == j + 1){
                    dp[i][j] = Integer.MAX_VALUE - 1;
                    continue;
                }
                int res = Integer.MAX_VALUE;
                if(j == 0){
                    if(obstacles[i] != 2)
                        res = Math.min(1 + dp[i + 1][1],dp[i + 1][0]);
                    if(obstacles[i] != 3)
                        res = Math.min(Math.min(1 + dp[i + 1][2],dp[i + 1][0]),res);
                }
                else if(j == 1){
                    if(obstacles[i] != 1)
                        res = Math.min(dp[i + 1][1],1 + dp[i + 1][0]);
                    if(obstacles[i] != 3)
                        res = Math.min(res,Math.min(1 + dp[i + 1][2],dp[i + 1][1]));
                }
                else{
                    if(obstacles[i] != 1)
                        res = Math.min(dp[i + 1][2], 1 + dp[i + 1][0]);
                    if(obstacles[i] != 2)
                        res = Math.min(res,Math.min(1 + dp[i + 1][1],dp[i + 1][2]));
                }
                dp[i][j] = res;
            }
        return dp[0][1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,2,2,1,0,3,0,3,0,1,3,1,1,0,1,3,1,1,1,0,2,0,0,3,3,0,3,2,2,0,0,3,3,3,0,0,2,0,0,3,3,0,3,3,0,0,3,1,0,1,0,2,3,1,1,0,3,3,0,3,1,3,0,2,2,0,1,3,0,1,0,3,0,1,3,1,2,2,0,0,3,0,1,3,2,3,2,1,0,3,2,2,0,3,3,0,3,0,0,1,0};
//        System.out.println(solution.minSideJumps(arr));
        System.out.println(solution.dp(arr));
    }
}
