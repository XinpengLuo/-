package 左神.暴力递归和动态规划.动态规划.刷题.只有两个键的键盘;

public class Solution {
    public int minSteps(int n) {
        return help(n,0,1);
    }
    public int help(int targetNum,int preNum, int curNum){
        if(curNum > targetNum)
            return 3000;
        if(curNum == targetNum)
            return 0;
        if(preNum == 0)
            return 1 + help(targetNum,curNum,curNum);
        return Math.min(2 + help(targetNum,curNum,curNum + curNum),1 + help(targetNum,preNum,curNum + preNum));
    }
    public int dp(int n){
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--)
            for(int j = n - 1; j >= 0; j--){
                if(j != 0)
                    dp[i][j] = Math.min(2 + getValue(dp,i + i,i),1 + getValue(dp,i + j,j));
                else
                    dp[i][j] = 1 + getValue(dp,i,i);
            }
        return dp[1][0];
    }
    public int getValue(int[][] dp, int i, int j){
        if(i > dp.length - 1)
            return 3000;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i = 3; i <= 20; i++){
            System.out.println(solution.minSteps(i) + " " + solution.dp(i));
        }
    }
}
