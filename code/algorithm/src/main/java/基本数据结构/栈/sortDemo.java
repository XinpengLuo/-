package 基本数据结构.栈;

public class sortDemo {

    public static void main(String[] args) {
        ListStack listStack = new ListStack();
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        listStack.push(node1);
        listStack.push(node2);
        Node node = listStack.pop();
        listStack.peek();
    }
}
//数组模拟的
class arrayStack{
    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    private int top = -1;
    //入栈
    public arrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    public boolean isFull(){
        if(this.top == maxSize - 1)
            return true;
        return false;
    }
    public void push(int data){
        if(isFull())
            return;
        this.top++;
        this.stack[top] = data;
    }
    public boolean isEmpty()
    {
        if(this.top == -1)
            return true;
        return false;
    }
    public int pop()
    {
        if(isEmpty())
            throw new RuntimeException("栈空");
        int data = stack[this.top];
        this.top--;
        return data;
    }
    public void list()
    {
        if(isEmpty())
            return;
        for (int i = top; i >= 0; i--) {
            System.out.println(i + " " + stack[i]);
        }
    }
}
//链表模拟的
class ListStack{
    private Node head = new Node(-1);
    private Node top = head;
    public boolean isEmpty()
    {
        if(top == head)
            return true;
        return false;
    }
    public void push(Node node)
    {
        top.setNext(node);
        top = top.getNext();
    }
    public Node pop()
    {
        if(isEmpty())
            return null;
        Node value = top;
        Node temp = this.head;
        while(temp.getNext() != top)
        {
            temp = temp.getNext();
        }
        temp.setNext(null);
        top = temp;
        return value;
    }
    public void  peek()
    {
        if(isEmpty())
            return;
        System.out.println(this.top.getValue());
    }
}
class Node{
    private int value;
    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int value){
        this.value = value;
    }
}