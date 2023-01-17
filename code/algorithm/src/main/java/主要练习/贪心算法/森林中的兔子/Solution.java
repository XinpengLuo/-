package 主要练习.贪心算法.森林中的兔子;

import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == 0) {
                res++;
                continue;
            }
            if(map.containsKey(answers[i]))
            {
                if(map.get(answers[i]) == 0)
                    map.remove(answers[i]);
                else
                    map.put(answers[i],map.get(answers[i]) - 1);
            }
            else{
                res += answers[i] + 1;
                map.put(answers[i],answers[i] - 1);
            }
        }
        return res;
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty)
            return  false;
        boolean[][] dp = new boolean[tx + 1][ty + 1];
        dp[tx][ty] = true;
        for(int i = dp.length - 1; i >= sx; i--)
            for(int j = dp[i].length - 1; j >= sy; j--){
                if(i + j < dp.length)
                    dp[i][j] = dp[i][j] || dp[i + j][j];
                if(i + j < dp[i].length)
                    dp[i][j] = dp[i][j] || dp[i][i + j];
            }
        return dp[sx][sy];
    }

    public static void main(String[] args) {
        int[] arr =  {1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.reachingPoints(10, 2, 2, 11));
    }
}