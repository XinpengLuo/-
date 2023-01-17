package 主要练习.暴力递归和动态规划.动态规划.刷题.火车票;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return help(days,costs,0,0);
    }
    public int help(int[] days, int[] costs, int day, int index){
        if(index >= days.length)
            return 0;
        if(days[index] <= day)
            return help(days,costs,day,index + 1);
        int res = Integer.MAX_VALUE;
        res = Math.min(res,help(days,costs,day + 1,index + 1) + costs[0]);
        res = Math.min(res,help(days,costs,day + 7,index + 1) + costs[1]);
        res = Math.min(res,help(days,costs,day + 30,index + 1) + costs[2]);
        return res;
    }
    public int helpOneDe(int[] days, int[] costs, int index){
        if(index >= days.length)
            return 0;
        int res = Integer.MAX_VALUE;
        int tempDay = days[index];
        int tempIndex = index;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 1)
            tempIndex++;
        res = Math.min(res,costs[0] + helpOneDe(days,costs,tempIndex));
        tempIndex = index;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 7)
            tempIndex++;
        res = Math.min(res,costs[1] + helpOneDe(days,costs,tempIndex));
        tempIndex = index;
        while (tempIndex < days.length && days[tempIndex] < tempDay + 30)
            tempIndex++;
        res = Math.min(res,costs[2] + helpOneDe(days,costs,tempIndex));
        return res;
    }
    public int dp(int[] days, int[] costs){
        int[] dp = new int[days.length + 1];
        for(int i = dp.length - 2; i >= 0; i--){
            int res = Integer.MAX_VALUE;
            int tempDay = days[i];
            int tempIndex = i;
            while (tempIndex < days.length && days[tempIndex] < tempDay + 1)
                tempIndex++;
            res = Math.min(res,costs[0] + dp[tempIndex]);
            tempIndex = i;
            while (tempIndex < days.length && days[tempIndex] < tempDay + 7)
                tempIndex++;
            res = Math.min(res,costs[1] + dp[tempIndex]);
            tempIndex = i;
            while (tempIndex < days.length && days[tempIndex] < tempDay + 30)
                tempIndex++;
            res = Math.min(res,costs[2] + dp[tempIndex]);
            dp[i] = res;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(solution.helpOneDe(days, costs, 0));
        System.out.println(solution.dp(days,costs));
    }
}
