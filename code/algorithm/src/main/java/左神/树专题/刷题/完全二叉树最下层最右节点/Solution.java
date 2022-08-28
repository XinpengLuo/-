package 左神.树专题.刷题.完全二叉树最下层最右节点;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public TreeNode lastLevelMostRightValue(TreeNode root){
        if(root == null || root.left == null)
            return root;
        int leftDepth = 0;
        TreeNode left = root.left;
        while (left != null){
            leftDepth++;
            left = left.left;
        }
        int rightDepth = 0;
        TreeNode right = root.right;
        while (right != null){
            rightDepth++;
            right = right.left;
        }
        if(leftDepth > rightDepth)
            return lastLevelMostRightValue(root.left);
        else
            return lastLevelMostRightValue(root.right);
    }
}
