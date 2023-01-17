package 主要练习.暴力递归和动态规划.动态规划.刷题.盈利计划;

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = (int)1e9 + 7;;
        int[][][] dp = new int[group.length + 1][minProfit + 1][n + 1]; // index tempValue leftPeople;
        for(int j = 0; j < n + 1; j++)
            dp[dp.length - 1][0][j] = 1;

        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j <= minProfit; j++)
                for(int k = 0; k <= n; k++){
                    int res = 0;
                    res += dp[i + 1][j][k];
                    if(k - group[i] >= 0)
                        res += dp[i + 1][j - profit[i] < 0 ? 0 : j - profit[i]][k - group[i]];
                    dp[i][j][k] = res % MOD;
                }
        // return help(n,minProfit,group,profit,0,0,n);
        return dp[0][minProfit][n];
    }
    public int help(int n, int minProfit, int[] group, int[] profit, int index, int leftPeople){

        if(leftPeople < 0)
            return 0;
        if(index == group.length){
            if(minProfit == 0)
                return 1;
            return 0;
        }
        return (help(n,minProfit,group,profit,index + 1, leftPeople)
                + help(n,minProfit - profit[index] < 0 ? 0 : minProfit - profit[index],group,profit,index + 1,leftPeople - group[index])) %  ((int)1e9 + 7);
    }
}
