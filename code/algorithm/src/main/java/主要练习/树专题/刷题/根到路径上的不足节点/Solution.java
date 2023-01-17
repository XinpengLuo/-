package 主要练习.树专题.刷题.根到路径上的不足节点;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        help(root,limit,0);
        return root;
    }
    public boolean help(TreeNode root, int limit, int tempSum){
        if(root == null)
            return true;
        int value = tempSum + root.val;
        boolean left = help(root.left,limit,value);
        boolean right= help(root.right,limit,value);
        if(root.left == null && root.right == null)
                {
                    if(value < limit)
                        return true;
                    else
                        return false;
                }
        if(left)
            root.left = null;
        if(right)
            root.right = null;
        if(left && right)
            return true;
        return false;
    }
}
