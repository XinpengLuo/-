package 主要练习.暴力递归和动态规划.动态规划.刷题.最小跳跃次数;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minJump(int[] jump) {
        return help(jump,0);
    }
    Queue<Integer> visited = new LinkedList<>();
    public int help(int[] jump, int index){
        if(index >= jump.length)
            return 0;
        if(visited.contains(index))
            return 100007;
        int res = Integer.MAX_VALUE;
        visited.add(index);
        for(int i = index - 1; i >= 0; i--)
                res = Math.min(res,1 + help(jump,i));
        res = Math.min(res,1 + help(jump,index + jump[index]));
        visited.remove(index);
        return res;
    }
//    public int dp(int[] jump){
//        int[] dp = new int[jump.length];
//
//    }
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2 == 0.3);
    }
}
