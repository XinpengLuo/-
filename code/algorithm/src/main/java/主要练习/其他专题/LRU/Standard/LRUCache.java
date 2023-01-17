package 主要练习.其他专题.LRU.Standard;

import java.util.HashMap;

class LRUCache {
    private HashMap<Integer,Node> map = new HashMap<>();
    private DoubleLinkedList list = new DoubleLinkedList();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node res = map.get(key);
            list.moveNodeToTail(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node res = map.get(key);
            res.value = value;
            list.moveNodeToTail(res);
            return;
        }
        Node node = new Node(key,value);
        map.put(key,node);
        list.addNode(node);
        if(map.size() == capacity + 1){
            Node head = list.removeHead();
            map.remove(head.key);
        }
    }
}
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class DoubleLinkedList{
    Node head;
    Node tail;
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    //添加元素 添加到末尾 优先级自动最高
    public void addNode(Node node){
        if(node == null)
            return;
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }
    //将某一元素移动到tail后面
    public void moveNodeToTail(Node node){
        if(node == tail)
            return;
        if(node == head){
            head = node.next;
            head.pre = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        tail.next = node;
        node.next = null;
        tail = node;
    }
    //当缓存溢出的时候 移除头部
    public Node removeHead(){
        if(head == null)
            return null;
        if(head == tail){
            head = null;
            tail = null;
            return null;
        }
        Node result = head;
        head = result.next;
        head.pre = null;
        result.next = null;
        return result;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */