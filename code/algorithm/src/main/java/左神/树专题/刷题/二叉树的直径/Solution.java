package 左神.树专题.刷题.二叉树的直径;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return help(root).maxPath - 1;
    }
    public ReturnData help(TreeNode root){
        if(root == null)
            return new ReturnData(0,0);
        ReturnData leftData = help(root.left);
        ReturnData rightData = help(root.right);
        int curPath = leftData.depth + rightData.depth + 1;
        int curDepth = Math.max(leftData.depth,rightData.depth) + 1;
        return new ReturnData(Math.max(Math.max(leftData.maxPath,rightData.maxPath),curPath),Math.max(Math.max(leftData.depth,rightData.depth),curDepth));
    }
}
class ReturnData{
    int maxPath;
    int depth;

    public ReturnData(int maxPath, int depth) {
        this.maxPath = maxPath;
        this.depth = depth;
    }
}
