package 生成器;

import 左神.树专题.公共节点.力扣.ListNode;
import 左神.树专题.公共节点.力扣.TreeNode;


import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateClass {
    //根据数组生成链表
    public static ListNode generateList(int[] arr){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i : arr) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
    //根据字符数组层次序列化二叉树
    public static TreeNode generateTree(String result){
        if(result.isEmpty())
            return null;
        String[] s = result.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(s[index++]));
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            temp.left = s[index].equals("null") ? null : new TreeNode(Integer.valueOf(s[index]));
            index++;
            temp.right = s[index].equals("null") ? null : new TreeNode(Integer.valueOf(s[index]));
            index++;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return head;
    }

    public static void main(String[] args) {
        String tree = "1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3,null,null,null,null";
        TreeNode treeNode = generateTree(tree);
        System.out.println(treeNode);
    }
}
