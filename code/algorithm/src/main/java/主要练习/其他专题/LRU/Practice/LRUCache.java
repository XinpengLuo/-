package 主要练习.其他专题.LRU.Practice;

import java.util.HashMap;

class LRUCache {
    HashMap<Integer,Node> map;
    DoubleLinkedList list;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        list = new DoubleLinkedList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.moveNodeToTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            list.moveNodeToTail(node);
            return;
        }
        if(map.size() == size)
        {
            map.remove(list.head.key);
            list.removeHead();
        }
        Node node = new Node(key,value);
        map.put(key, node);
        list.insertNode(node);
    }
}
class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class DoubleLinkedList{
    Node head;
    Node tail;
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    public void insertNode(Node node){
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.pre = tail;
        tail = node;
    }
    public void removeHead(){
        if(head == null)
            return;
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        Node temp = head.next;
        head = null;
        head = temp;
    }
    public void moveNodeToTail(Node node){
        if(node == tail || head == tail)
            return;
        if(node == head){
            head = node.next;
            head.pre = null;
        }
        else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */