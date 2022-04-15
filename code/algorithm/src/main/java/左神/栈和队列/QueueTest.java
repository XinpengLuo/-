package 左神.栈和队列;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueTest {
    public static void main(String[] args) {
       StackQueue stackQueue = new StackQueue();
       for(int i = 0; i < 10; i++)
           stackQueue.push(i);
        for(int i = 0; i < 10; i++)
            System.out.println(stackQueue.pop());
    }
}
//用两个队列来模拟栈
class QueueStack{
    private Queue<Integer> data;
    private Queue<Integer> help;
    public QueueStack(){
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }
    public void push(int num){
        data.add(num);
    }
    public int peek(){
        if(data.isEmpty())
            throw new RuntimeException();
        while (data.size() != 1){
            help.add(data.poll());
        }
        int result = data.poll();
        swap();
        data.add(result);
        return result;
    }
    public int pop(){
        if(data.isEmpty())
            throw new RuntimeException();
        while (data.size() != 1){
            help.add(data.poll());
        }
        int result = data.poll();
        swap();
        return result;
    }
    private void swap() {
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }
}
//用两个栈来模拟队列
class StackQueue{
    private Stack<Integer> data;
    private Stack<Integer> help;
    public StackQueue(){
        data = new Stack<>();
        help = new Stack<>();
    }
    private void reLoad(){
        if(!help.isEmpty())
            return;
        while (!data.isEmpty())
            help.push(data.pop());
    }
    public void push(int num){
        data.push(num);
    }
    public int peek(){
        if(data.size() == 0 && help.size() == 0)
            throw new RuntimeException();
        reLoad();
        return help.peek();
    }
    public int pop(){
        if(data.size() == 0 && help.size() == 0)
            throw new RuntimeException();
        reLoad();
        return help.pop();
    }
}
