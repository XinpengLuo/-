package 左神.树专题.刷题.填充右指针;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TransferQueue;

public class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            while (size-- > 0){
                Node left = queue.poll();
                if(size != 0)
                    left.next = queue.peek();
                if(left.left != null)
                    queue.add(left.left);
                if(left.right != null)
                    queue.add(left.right);
            }
        }
        return root;
    }
    public void connectHelp(Node root, Node next){
        if(root == null)
            return;
        root.next = next;
        connectHelp(root.left,root.right);
        if(root.next != null)
            connectHelp(root.right,root.next.left);
        else
            connectHelp(root.right,null);
    }


}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}