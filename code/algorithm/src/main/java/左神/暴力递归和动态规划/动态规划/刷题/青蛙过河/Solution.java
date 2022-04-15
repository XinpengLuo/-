package 左神.暴力递归和动态规划.动态规划.刷题.青蛙过河;

public class Solution {
    public boolean canCross(int[] stones) {
//        return help(stones,1,1,1);
        return dp(stones);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,1,3,6,10,15,16,21};
        System.out.println(solution.canCross(arr));
    }
    //递归三个参数
    public boolean help(int[] stones, int arrIndex, int step, int curValue){
        if(curValue > stones[stones.length - 1])
            return false;
        if(arrIndex == stones.length - 1)
            {
                if(curValue == stones[stones.length - 1])
                    return true;
                return false;
            }
        if(stones[arrIndex] != curValue) {
            for (int i = arrIndex + 1; i < stones.length; i++)
                if (stones[i] == curValue)
                    return help(stones, i, step, curValue);
                return false;
        }
        else
            return
                    help(stones,arrIndex + 1,step - 1,curValue + step - 1)
                    || help(stones,arrIndex + 1,step + 1,curValue + step + 1)||
                            help(stones,arrIndex + 1,step,curValue + step)
                    ;
    }
    //递归两个参数 步长 当前来到的下标
    public boolean bfs(int[] stones, int step, int arrIndex){
        if(arrIndex == stones.length - 1)
            return true;
        boolean flag = false;
        for(int i = arrIndex + 1; i < stones.length; i++){
            int gap = stones[i] - stones[arrIndex];
            if(step - 1 <= gap && gap <= step + 1){
                flag = bfs(stones,gap,i);
                if(flag)
                    return true;
            }
            else if(gap > step + 1) //两个相连的石头的距离 比最大的步子还要大 那么不用往下找了 直接退出循环 减少分支
                break;
            //如果小 继续循环
        }
        return false;
    }

        public boolean dp(int[] stones) {
            boolean[][] dp = new boolean[stones.length][stones.length];
            for(int i = 0; i < dp[0].length; i++)
                dp[stones.length - 1][i] = true;
            for(int i = dp.length - 2; i >= 0; i--)
                for(int j = 0; j < dp[i].length; j++){ //i --> index j --> step
                    for(int k = i + 1; k < stones.length; k++){
                        int gap = stones[k] - stones[i];
                        if(j - 1 <= gap && gap <= j + 1){
                            if(gap < stones.length && dp[k][gap])
                                dp[i][j] = true;
                        }
                        else if(gap > j + 1)
                            break;
                    }
                }
            return dp[0][0];
        }
    }
