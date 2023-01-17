package 主要练习.树专题.视频.镜像二叉树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        TreeNode tempNode = null;
        while (!queue.isEmpty()){
            temp = queue.poll();

            tempNode = temp.left;
            temp.left = temp.right;
            temp.right = tempNode;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);

        }
        return root;
    }
}
