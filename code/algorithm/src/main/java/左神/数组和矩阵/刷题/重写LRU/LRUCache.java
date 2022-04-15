package 左神.数组和矩阵.刷题.重写LRU;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<Integer, Node>();
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node res = map.get(key);
            doubleLinkedList.moveNodetoTail(res);
            return res.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            doubleLinkedList.moveNodetoTail(temp);
            return;
        }
        Node node = new Node(key,value);
        if(map.size() == capacity) {
            Node temp = doubleLinkedList.removeHead();
            map.remove(temp.key);
        }
        doubleLinkedList.addNode(node);
        map.put(key,node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);
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
    public void addNode(Node node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }
    public void moveNodetoTail(Node node){
        if(node == tail)
            return;
        else if(node == head){
            head = head.next;
            head.pre = null;
        }
        else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
    }
    public Node removeHead(){
        if(head == null)
            return null;
        if(head == tail){
            Node res = head;
            head = null;
            tail = null;
            return res;
        }
        Node res = head;
        head = head.next;
        head.pre = null;
        res.next = null;
        return res;
    }
}