package 左神.其他专题.LRU;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer,Node> map;
    int size;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            moveToTail(node);
            return node.val;
        }
        return -1;
    }
    //在这里我们用tail 表示最近使用的位置
    public void moveToTail(Node node){
        if(node == tail || tail == head)
            return;
        if(node == head){
            head = node.next;
            node.next.pre = null;
        }
        else
            {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
        tail.next = node;
        node.pre = tail;
        tail = node;
        node.next = null;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }
        if(map.size() == size){
            map.remove(head.key);
            if(head == tail){
                head = null;
                tail = null;
            }
            else
                {
                    head = head.next;
                    head.pre = null;
                }
        }
        Node node = new Node(key,value);
        map.put(key,node);
        insertNode(node);
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
        node.next = null;
    }
}
class Node{
    int val;
    Node pre;
    Node next;
    int key;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */