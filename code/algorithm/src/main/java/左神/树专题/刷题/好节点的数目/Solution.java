package 左神.树专题.刷题.好节点的数目;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
       return help(root,root.val);
    }
    public int help(TreeNode root, int preValue){
        if(root == null)
            return 0;
        int res = 0;
        if(root.val >= preValue){
            res++;
            preValue = root.val;
        }
        return res + help(root.left,preValue) + help(root.right,preValue);
    }
}
