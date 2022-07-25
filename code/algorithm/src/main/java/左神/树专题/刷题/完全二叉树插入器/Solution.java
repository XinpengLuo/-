package 左神.树专题.刷题.完全二叉树插入器;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
}
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        while(!tempQueue.isEmpty()){
            TreeNode temp = tempQueue.poll();
            if(temp.left != null) {
                tempQueue.add(temp.left);
            }
            if(temp.right != null){
                tempQueue.add(temp.right);
            }
            if(temp.left == null || temp.right == null) {
                queue.add(temp);
            }
        }
    }

    public int insert(int val) {
        TreeNode temp = queue.peek();
        TreeNode node = new TreeNode(val);
        queue.add(node);
        if(temp.left == null){
            temp.left = node;
        }
        else if(temp.right == null)
        {
            temp.right = node;
        }
        if(temp.left != null && temp.right != null){
            queue.poll();
        }
        return temp.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}