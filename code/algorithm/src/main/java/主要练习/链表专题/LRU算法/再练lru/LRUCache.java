package 主要练习.链表专题.LRU算法.再练lru;

import java.util.*;

class LRUCache {
    int size = 0;
    HashMap<Integer,Node> map;
    DoubleLinkedList list;
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        list = new DoubleLinkedList();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        list.moveNodeToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.moveNodeToTail(node);
            node.val = value;
            return;
        }
        if(map.size() == size){
            map.remove(list.head.key);
            list.removeNode();
        }
        Node node = new Node(key,value);
        list.addNewNode(node);
        map.put(key,node);
    }
}
class Node{
    int val;
    int key;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}
class DoubleLinkedList{
    Node head;
    Node tail;

    public void moveNodeToTail(Node node) {
        if(node == tail || head == tail)
            return;
        if(node == head){
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

    public void removeNode() {
        if(head == null)
            return;
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.pre = null;
    }

    public void addNewNode(Node node) {
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.pre = tail;
        tail = node;
    }
}