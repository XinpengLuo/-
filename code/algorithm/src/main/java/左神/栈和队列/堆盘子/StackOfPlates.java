package 左神.栈和队列.堆盘子;

import java.util.*;

class StackOfPlates {

    List<Stack<Integer>> list = new ArrayList<>();
    int size;
    public StackOfPlates(int cap) {
        size = cap;
    }

    public void push(int val) {
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).size() < size) {
                list.get(i).push(val);
                return;
            }
        Stack<Integer> stack = new Stack<>();
        stack.push(val);
        list.add(stack);
    }

    public int pop() {
        if(list.size() == 0)
            return -1;
        Integer res = list.get(0).pop();
        if(list.get(0).isEmpty())
            list.remove(0);
        return res;
    }

    public int popAt(int index) {
        if(index - 1 >= list.size())
            return -1;
        int res = list.get(index - 1).pop();
        if(list.get(index - 1).isEmpty())
            list.remove(index - 1);
        return res;
    }
}
