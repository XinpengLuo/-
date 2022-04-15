package 左神.栈和队列.单调栈.队列中可以看到的人数;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>(); //这里存放下标 不存放值 维护一个从栈底到栈顶从大到小的
        int n = heights.length;
        int[] res = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int count = 0;
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]){
                count++;
                stack.pop();
            }
            if(!stack.isEmpty())
                count++;
            res[i] = count;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {10,6,8,5,11,9};
        Solution solution = new Solution();
        solution.canSeePersonsCount(test);
    }
}
