package 主要练习.树专题.刷题.二叉树的堂兄节点;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class Solution {
    int depX = 0;
    int depY = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xFather = getNodeFather(root, x);
        TreeNode yFather = getNodeFather(root, y);
        getNodeDepth(root,x,y,0);
        if(depY == depX && xFather != yFather)
            return true;
        return false;
    }
    public TreeNode getNodeFather(TreeNode root, int val){
        if(root == null)
            return null;
        if((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val))
            return root;
        TreeNode left = getNodeFather(root.left, val);
        TreeNode right = getNodeFather(root.right,val);
        if(left != null)
            return left;
        else
            return right;
    }
    public void getNodeDepth(TreeNode root, int valX, int valY, int depth){
        if(root == null)
            return;
        if(root.val == valX)
            depX = depth;
        if(root.val == valY)
            depY = depth;
        getNodeDepth(root.left,valX,valY,depth + 1);
        getNodeDepth(root.right,valX,valY,depth + 1);
    }
}
