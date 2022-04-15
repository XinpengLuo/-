package 左神.栈和队列.最小栈;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
       stack.pop();
       minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
