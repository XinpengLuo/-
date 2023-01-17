package 主要练习.树专题.视频.序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class SequenceTree {
    //先序遍历的序列化
    public static String preSequenceFy(Node head){
        String result = "";
        if(head == null)
            return  "#_";
        result += head.val + "_";
        result += preSequenceFy(head.left);
        result += preSequenceFy(head.right);
        return result;
    }
    //先序遍历的反序列化
    public static Node preReSequenceFy(String result){
        String[] s = result.split("_");
        index = 0;
        return preReSequenceFy(s);
    }
    //注意这个变量 因为是基本类型 递归时并不传递地址
    static int index = 0;
    public static Node preReSequenceFy(String[] s){
        if(s[index] == "#")
            {
                index++;
                return null;
            }
        Node head = new Node(Integer.valueOf(s[index++]));
        head.left = preReSequenceFy(s);
        head.right = preReSequenceFy(s);
        return head;
    }

    //中序遍历的序列化
    public static String inSequenceFy(Node head){
         String result = "";
         if(head == null)
             return "#_";
         result += inSequenceFy(head.left);
         result += head.val + "_";
         result += inSequenceFy(head.right);
         return result;
    }
    //中序遍历的反序列化
    public static Node inReSequenceFy(String result){
        String[] s = result.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String v : s) {
            queue.add(v);
        }
        return inReSequenceFy(queue);
    }

    private static Node inReSequenceFy(Queue<String> queue) {
        if(queue.poll() == "#")
            return null;

        return null;
    }
    //二叉树的按层序列化
    public static String levelSequence(Node head){
        if(head == null)
            return "";
        StringBuilder result = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        result.append(head.val + "_");
        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.left != null)
                {
                    result.append(temp.left.val + "_");
                    queue.add(temp.left);
                }
            else
                result.append("#_");
            if(temp.right != null)
                {
                    result.append(temp.right.val + "_");
                    queue.add(temp.right);
                }
            else
                result.append("#_");
        }
        return result.toString();
    }
    //二叉树的层序反序列化
    public static Node levelReSequence(String result){
        if(result.isEmpty())
            return null;
        String[] s = result.split("_");
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node head = new Node(Integer.valueOf(s[index++]));
        queue.add(head);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            temp.left = s[index].equals("#") ? null : new Node(Integer.valueOf(s[index]));
            index++;
            temp.right = s[index].equals("#") ? null : new Node(Integer.valueOf(s[index]));
            index++;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return head;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setRight(new Node(4));
        System.out.println(levelSequence(root));
        System.out.println(levelSequence(levelReSequence(levelSequence(root))));
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

