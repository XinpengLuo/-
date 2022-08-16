package 左神.栈和队列.设计循环双端队列;

class MyCircularDeque {

    int[] queue;
    int size;
    int front;
    int end;
    public MyCircularDeque(int k) {
        queue = new int[k];
        size = 0;
        front = 0;
        end = 0;
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;
        front = (front - 1 + queue.length) % queue.length;
        queue[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;
        queue[end] = value;
        end = (end + 1) % queue.length;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;
        size--;
        front = (front + 1) % queue.length;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        size--;
        end = (end - 1 + queue.length) % queue.length;
        return true;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return queue[front];
    }

    public int getRear() {
        if(isEmpty())
            return -1;
        return queue[(end - 1 + queue.length) % queue.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}

