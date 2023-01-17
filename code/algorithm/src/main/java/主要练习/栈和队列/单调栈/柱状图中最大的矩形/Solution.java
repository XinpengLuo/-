package 主要练习.栈和队列.单调栈.柱状图中最大的矩形;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        //从小到大的顺序 栈底到栈顶 保存的是下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {

                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    int index = stack.pop();
                    int j = stack.isEmpty() ? -1 : stack.peek();
                    maxArea = Math.max(maxArea,heights[index] * (i - j - 1));
                }

                stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int j = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea,heights[index] * (heights.length - j - 1));
        }
        return maxArea;
    }
}
