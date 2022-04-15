package 左神.树专题.刷题.祖父节点值为偶数;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return help(root);
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        int res = 0;
        if(root.val % 2 == 0){
            if(root.left != null){
                if(root.left.left != null)
                    res += root.left.left.val;
                if(root.left.right != null)
                    res += root.left.right.val;
            }
            if(root.right != null){
                if(root.right.left != null)
                    res += root.right.left.val;
                if(root.right.right != null)
                    res += root.right.right.val;
            }
        }
        return res + help(root.left) + help(root.right);
    }
}
