package 左神中级班.第三节.将栈里的数据排序;

import java.util.Stack;

public class Solution {
    public void oderStack(Stack<Integer> stack){
        if(stack == null || stack.isEmpty())
            return;
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            int tempNumber = stack.pop();
            if(temp.isEmpty() || tempNumber < temp.peek())
                temp.push(tempNumber);
            else {
                while (!temp.isEmpty() && temp.peek() < tempNumber)
                    stack.push(temp.pop());
                temp.push(tempNumber);
            }
        }
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(13);
        stack.push(7);
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        Solution solution = new Solution();
        solution.oderStack(stack);
        System.out.println();
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
    }
}
