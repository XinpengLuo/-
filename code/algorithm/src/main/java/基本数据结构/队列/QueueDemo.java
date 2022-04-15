package 基本数据结构.队列;


public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(2);
    }
}
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //该数组用于存放数据
    //创建队列的构造器
    public ArrayQueue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isEmpty()
    {
        return front == rear;
    }
    public boolean isFull()
    {
        return maxSize == rear + 1;
    }
    //入队列
    public void addQueue(int n){
        if(isFull())
            return;
        this.rear++;
        arr[rear] = n;
    }
    //出队列
    public int getQueue()
    {
        if(isEmpty())
            throw new RuntimeException();
        this.front++;
        return arr[front];
    }
    //显示队列
    public void showQueue()
    {
        if(isEmpty())
            return;
        for(int i = front + 1; i <= rear; i++)
            System.out.println(arr[i]);
    }
    //显示队列的头部的数据
    public int peakQueue()
    {
        if(isEmpty())
            throw new RuntimeException();
        return arr[front + 1];
    }
}
class CircleQueue
{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //该数组用于存放数据
    //创建队列的构造器
    public CircleQueue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    public boolean isEmpty()
    {
        return front == rear;
    }
    public boolean isFull()
    {
        return (rear + 1) % maxSize == front;
    }
    //入队列
    public void addQueue(int n){
        if(isFull())
            return;
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }
    //取数据
    public int getQueue()
    {
        if(isEmpty())
            throw new RuntimeException();
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //求出当前队列有效数据的个数
    public int getLength()
    {
        return (rear - front + maxSize) % maxSize;
    }
    //显示队列
    public void showQueue()
    {
        if(isEmpty())
            return;
        //从front开始遍历 遍历有效数据个数的次
        for(int i = front; i < front + getLength(); i++)
            System.out.println(arr[i % maxSize]);
    }
}