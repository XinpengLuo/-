package 左神.树专题.刷题.找出克隆二叉树;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return help(cloned,target);
    }
    public TreeNode help(TreeNode cloned, TreeNode target){
        if(cloned == null)
            return null;
        if(findIsSame(cloned,target))
            return cloned;
        TreeNode left = help(cloned.left, target);
        if(left != null)
            return left;
        else
            return help(cloned.right,target);
    }
    public boolean findIsSame(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return findIsSame(left.left,right.left) && findIsSame(left.right,right.right);
    }
}
