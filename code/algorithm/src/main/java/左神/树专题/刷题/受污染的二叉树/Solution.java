package 左神.树专题.刷题.受污染的二叉树;

import 左神.树专题.公共节点.力扣.TreeNode;

import javax.swing.border.AbstractBorder;

public class Solution {
}
class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;
        help(this.root);
    }
    public void help(TreeNode root){
        if(root.left != null){
            root.left.val = 2 * root.val + 1;
            help(root.left);
        }
        if(root.right != null){
            root.right.val = 2 * root.val + 2;
            help(root.right);
        }
    }
    public boolean find(int target) {
        return find(this.root,target);
    }
    public boolean find(TreeNode root, int target){
        if(root == null)
            return false;
        if(root.val == target)
            return true;
        return find(root.left,target) || find(root.right,target);
    }
}