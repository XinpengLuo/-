package 左神.树专题.刷题.在二叉树中增加一行;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            d--;
            while (size-- > 0){
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                if(d == 1){
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    newLeft.left = temp.left;
                    newRight.right = temp.right;
                    temp.left = newLeft;
                    temp.right = newRight;
                }
            }
        }
        return root;
    }
}
