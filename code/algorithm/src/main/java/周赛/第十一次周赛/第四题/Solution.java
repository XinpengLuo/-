package 周赛.第十一次周赛.第四题;

public class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < tires.length; i++){
            int temp = (dp(tires,changeTime,numLaps,i));
            res = Math.min(res,temp);
        }
        return res;
    }
    public int help(int[][] tries, int changeTime, int numLaps, int curTrieLap, int curIndex){
        if(numLaps == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        //继续用当前轮胎
        int temp = (int) (tries[curIndex][0] * (Math.pow(tries[curIndex][1],curTrieLap)));
        res = (int) Math.min(res, help(tries,changeTime,numLaps - 1,curTrieLap + 1,curIndex) + temp);
        //如果更换其他的
        for(int i = 0; i < tries.length; i++){
            int f = tries[i][0];
            res = Math.min(res,help(tries,changeTime,numLaps - 1,1,i) + changeTime + f);
        }
        return res;
    }
    public int dp(int[][] tries, int changeTime, int numLaps, int curIndex){
        int[][][] dp = new int[numLaps + 1][tries.length][numLaps + 1]; //cur index numTap
        for(int i = 1; i <= numLaps; i++){ //代表z轴 numTap
            for(int j = 0; j <= numLaps - 1; j++) //cur
                for(int k = 0; k < tries.length; k++) //index
                {
                    int res = Integer.MAX_VALUE;
                    double temp = (tries[k][0] * Math.pow(tries[k][1],j));
                    res = (int) Math.min(res,dp[j + 1][k][i - 1] + temp);
                    //如果更换其他的
                    for(int index = 0; index < tries.length; index++){
                        int f = tries[index][0];
                        res = Math.min(res,dp[1][index][i - 1] + changeTime + f);
                    }
                    dp[j][k][i] = res;
                }
        }
        return dp[0][curIndex][numLaps];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] tires = {{99,7}};
        System.out.println(solution.minimumFinishTime(tires, 85, 95));
    }
}
