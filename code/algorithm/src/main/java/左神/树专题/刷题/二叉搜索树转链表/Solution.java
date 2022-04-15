package 左神.树专题.刷题.二叉搜索树转链表;

import 左神.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //morris遍历
    public void morris(Node root){

        Node cur = root;
        Node mostRight = null;
        Node pre = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null)
                    {
                        mostRight.right = cur;
                        cur = cur.left;
                        continue;
                    }

            }
//            System.out.println(cur.val + " ");
            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Node treeNode = generateTree("28,-98,67,null,-89,62,null,-97,-25,null,64,null,null,-72,-9,null,null,-88,-41,null,-7,null,-78,-53,null,null,2,-85,-77,-69,-42,-1,null,null,null,null,null,null,null,null,null,null,null");
        morris(treeNode);
       Node mostLeft = null;
       Node mostRight = null;
       Node temp = treeNode;
       while (temp.left != null)
           temp = temp.left;
       mostLeft = temp;
       temp = treeNode;
       while (temp.right != null)
           temp = temp.right;
       mostRight = temp;
       mostLeft.left = mostRight;
       mostRight.right = mostLeft;
       Node cur = mostRight;
       while (cur.left != mostRight){
           cur.left.right = cur;
           cur = cur.left;
       }
       return mostLeft;
    }
    public static Node generateTree(String result){
        if(result.isEmpty())
            return null;
        String[] s = result.split(",");
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node head = new Node(Integer.valueOf(s[index++]));
        queue.add(head);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            temp.left = s[index].equals("null") ? null : new Node(Integer.valueOf(s[index]));
            index++;
            temp.right = s[index].equals("null") ? null : new Node(Integer.valueOf(s[index]));
            index++;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(null);
        Node head = node;
        while (node.right != head)
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};