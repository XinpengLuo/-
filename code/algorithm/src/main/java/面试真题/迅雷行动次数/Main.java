package 面试真题.迅雷行动次数;

import java.util.*;

public class Main {
    static HashMap<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] split = s.split(",");
        int target = Integer.parseInt(split[0]);
        int time = Integer.parseInt(split[1]);
        System.out.println(dp(1,target,time));
    }
    public static int better(int time, int target){
        int num = 1;
        int count = 0;
        while (time != 0 && num * 2 <= target){
            time--;
            num *= 2;
            count++;
        }
        count += target - num;
        return count;
    }
    public static int dfs(int num, int target, int time){
        if(num > target)
            return 100000;
        if(num == target)
            return 0;
        String key = num + "_" + time;
        if(map.containsKey(key))
            return map.get(key);

        int res = 0;
        String leftKey = (num + 1) + "_" + time;
        if(map.containsKey(leftKey))
            res = map.get(leftKey);
        else {
            res = dfs(num + 1, target, time);
            map.put(leftKey,res);
        }

        if(time != 0) {
            String rightKey = (num * 2) + "_" + (time - 1);
            int temp = 0;
            if(map.containsKey(rightKey))
                temp = map.get(rightKey);
            else {
                temp = dfs(num * 2, target, time - 1);
                map.put(rightKey,temp);
            }
            res = Math.min(temp, res);
        }

        map.put(key,res + 1);
        return res + 1;
    }
    public static int dp(int num, int target, int time){
        int[][] dp = new int[target + 1][time + 1];
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = dp[i + 1][j];
                if(j != 0 && i * 2 < dp.length)
                    dp[i][j] = Math.min(dp[i * 2][j - 1],dp[i][j]);
                dp[i][j]++;
            }
        return dp[num][time];
    }
}
