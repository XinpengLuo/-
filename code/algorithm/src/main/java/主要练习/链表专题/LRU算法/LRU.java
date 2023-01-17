package 主要练习.链表专题.LRU算法;

import java.util.HashMap;

public class LRU {
    public static void main(String[] args) {
        myCache<Integer,String> myCache = new myCache<>(3);
        myCache.set(1,"罗新鹏");
        myCache.set(2,"黄秋生");
        myCache.set(3,"吴镇宇");
        myCache.showList();
    }
}
class Node<K,V>{
    K key;
    V value;
    Node<K,V> pre;
    Node<K,V> next;
    public Node(K key,V val){
        this.key = key;
        this.value = val;
    }
}
class DoubleLinkedList<K,V>{
    Node<K,V> head;
    Node<K,V> tail;
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    //往双向链表中添加元素
    public void addNode(Node node){
        if(node == null)
            return;
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            //注意添加的时候 是添加到尾节点后面 所以优先级自动提升为最大
            this.tail.next = node;
            node.pre = this.tail;
            this.tail = node;
        }
    }
    //将某一元素移动到末尾 即提高优先级
    public void moveNodeToTail(Node node){
        if(node == this.tail)
            return;
        if(node == this.head){
            this.head = node.next;
            this.head.pre = null;
        }
        else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = null;
        this.tail.next = node;
        node.pre = this.tail;
        this.tail = node;
    }
    public Node removeHead(){
        if(this.head == null)
            return null;
        Node res = this.head;
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = res.next;
            this.head.pre = null;
            res.next = null;
        }
        return res;
    }
}
class myCache<K,V>{
    private HashMap<K,Node<K,V>> keyNodeMap;
    private DoubleLinkedList<K,V> nodeList;
    private int capacity;
    public myCache(int capacity){
        keyNodeMap = new HashMap<>();
        nodeList = new DoubleLinkedList<>();
        this.capacity = capacity;
    }
    public V get(K key){
        if(this.keyNodeMap.containsKey(key)){
            Node<K,V> res = keyNodeMap.get(key);
            nodeList.moveNodeToTail(res);
            return res.value;
        }
        return null;
    }
    public void set(K key, V value){
        if(keyNodeMap.containsKey(key)){ // 如果有便修改 并且提高优先级
            Node<K,V> node = keyNodeMap.get(key);
            node.value = value;
            nodeList.moveNodeToTail(node);
            return;
        }
        Node node = new Node(key, value);
        keyNodeMap.put(key,node);
        nodeList.addNode(node);
        if(keyNodeMap.size() == capacity + 1){
            Node head = nodeList.removeHead();
            keyNodeMap.remove(head.key);
        }
    }
    public void showList(){
        Node temp = nodeList.head;
        while (temp != null){
            System.out.print(temp.key + " : " + temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}