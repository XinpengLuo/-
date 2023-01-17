package 主要练习.字符串.避免重复字母的最小删除成本;

public class Solution {
    public int minCost(String s, int[] cost) {
        int[] dp = new int[s.length()];
        for(int i = 1; i < dp.length; i++){
            if(s.charAt(i) == s.charAt(i - 1))
                {
                    dp[i] = Math.min(cost[i],cost[i - 1])  + dp[i - 1];
                    cost[i] = Math.max(cost[i],cost[i - 1]);
                }
            else
                dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];
    }

    public int help(String s, int[] cost, int preIndex, int index){
        if(index == s.length())
            return 0;
        if(s.charAt(index) == s.charAt(preIndex))
            return Math.min(cost[preIndex] + help(s,cost,index,index + 1), cost[index] + help(s,cost,preIndex,index + 1));
        return help(s,cost,index,index + 1);
    }
}
