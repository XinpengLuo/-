package 主要练习.暴力递归和动态规划.动态规划.刷题.跳跃游戏4;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        return help(arr,0,queue);
    }
    public int help(int[] arr, int index, Queue<Integer> queue){
        if(index < 0 || index >= arr.length || queue.contains(index))
            return 10000;
        if(index == arr.length - 1)
            return 0;
        queue.add(index);
        int res = 10000;
        res = Math.min(res,1 + help(arr,index + 1,queue));
        res = Math.min(res,1 + help(arr,index - 1,queue));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[index] && index != i)
                res = Math.min(res,1 + help(arr,i,queue));
        }
        return res;
    }
}
