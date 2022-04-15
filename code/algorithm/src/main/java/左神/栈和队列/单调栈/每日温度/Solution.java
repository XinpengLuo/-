package 左神.栈和队列.单调栈.每日温度;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, preIndex = 0;
        int[] res = new int[T.length];
        while (i < T.length){
            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.push(i);
                i++;
                continue;
            }
            int temp = stack.pop();
            res[temp] = i - temp;
        }
        return res;
    }
}
