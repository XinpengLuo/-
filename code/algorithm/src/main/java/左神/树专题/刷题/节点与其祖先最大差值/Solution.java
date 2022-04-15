package 左神.树专题.刷题.节点与其祖先最大差值;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int getMin(TreeNode root){
        if(root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(getMin(root.left),getMin(root.right)));
    }
    public int getMax(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(getMax(root.left),getMax(root.right)));
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return Integer.MIN_VALUE;
        int result = 0;
        result = Math.max(Math.abs(root.val - getMax(root)),Math.abs(root.val - getMin(root)));
        result = Math.max(maxAncestorDiff(root.left),result);
        result = Math.max(maxAncestorDiff(root.right),result);
        return result;
    }
}
