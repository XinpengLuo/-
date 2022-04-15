package 左神.栈和队列.单调栈;

import 左神.树专题.公共节点.力扣.ListNode;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        Integer peek = stack.peek();
        peek = 2;
        System.out.println(stack.pop());
    }
}
