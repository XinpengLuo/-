package 主要练习.树专题.视频;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDemo {
    Node root;
    public BinaryTreeDemo(int val){
        this.root = new Node(val);
    }
    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.getVal());
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void infixOrder(Node node){
        if(node != null){
            preOrder(node.left);
            System.out.println(node.getVal());
            preOrder(node.right);
        }
    }
    public void preOrderLoop(Node node){
        if(node != null){
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()){
                node = stack.pop();
                System.out.println(node.val);
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
    }
    //二叉树的层次遍历
    public void treeLevelOrder(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeDemo tree = new BinaryTreeDemo(1);
        tree.getRoot().setLeft(new Node(2));
        tree.getRoot().setRight(new Node(3));
        tree.treeLevelOrder(tree.getRoot());
    }
}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
