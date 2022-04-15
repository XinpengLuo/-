package 左神.树专题.刷题.统计同值子树;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        return count(root);
    }
    public int count(TreeNode root){
        if(root == null)
            return 0;
        int res = 0;
        if(help(root,root.val))
            res++;
        res += (count(root.left) + count(root.right));
        return res;
    }
    public boolean help(TreeNode root, int preVal){
       if(root == null)
           return true;
       if(root.val != preVal)
           return false;
       return help(root.left,root.val) && help(root.right,root.val);
    }
}
