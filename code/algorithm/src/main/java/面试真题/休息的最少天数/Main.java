package 面试真题.休息的最少天数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //0 -- > 啥也没干 1 --> 工作了 2 --> 健身了
    public static int getAnswer(int index, int[] work, int[] sport, int n, int status){
        if(index >= n)
            return 0;
        int workRes = Integer.MAX_VALUE;
        int sportRes = Integer.MAX_VALUE;
        int relaxRes = 1 + getAnswer(index + 1,work,sport,n,0);
        if(status == 0){
            if(work[index] == 1)
                workRes = getAnswer(index + 1, work, sport, n, 1);
            if(sport[index] == 1)
                sportRes = getAnswer(index + 1, work,sport, n,2);
            return Math.min(workRes,Math.min(sportRes,relaxRes));
        }
        else if(status == 1){ //前一天工作了
            if(sport[index] == 1)
                sportRes = getAnswer(index + 1, work,sport, n,2);
            return Math.min(sportRes,relaxRes);
        }
        else{
            if(work[index] == 1)
                workRes = getAnswer(index + 1, work, sport, n, 1);
            return Math.min(sportRes,relaxRes);
        }
    }
    public static int dp(int[] work, int sport[]){
        int[][] dp = new int[work.length + 1][3];
        for(int i = dp.length - 2; i >= 0; i--){
            int workRes = dp[i + 1][1];
            int sportRes = dp[i + 1][2];
            int relaxRes = 1 + dp[i + 1][0];
            dp[i][0] = relaxRes;
            dp[i][1] = relaxRes;
            dp[i][2] = relaxRes;
            if(work[i] == 1){ //今天可以去工作
                dp[i][0] = Math.min(dp[i][0],workRes);
                dp[i][2] = Math.min(dp[i][2],workRes);
            }
            if(sport[i] == 1){
                dp[i][0] = Math.min(dp[i][0],sportRes);
                dp[i][1] = Math.min(dp[i][1],sportRes);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] work = new int[n];
        int[] sport = new int[n];
        for(int i = 0; i < work.length; i++)
            work[i] = scanner.nextInt();
        for(int i = 0; i < sport.length; i++)
            sport[i] = scanner.nextInt();
        System.out.println(dp(work,sport));
    }
}
