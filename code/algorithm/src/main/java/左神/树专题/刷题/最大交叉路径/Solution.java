package 左神.树专题.刷题.最大交叉路径;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    int longestPath = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        help(root,0,true);
        help(root,0,false);
        return longestPath;
    }
    public void help(TreeNode root,int count,boolean flag){
        longestPath = Math.max(longestPath,count);
        if(flag){
            if(root.left != null)
                help(root.left,count + 1,!flag);
            if(root.right != null)
                help(root.right,1,flag);
        }
        else{
            if(root.right != null)
                help(root.right,count + 1,!flag);
            if(root.left != null)
                help(root.left,1,flag);
        }
    }
}
