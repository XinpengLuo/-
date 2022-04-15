package 左神.树专题.刷题.最长同值路径;

import 左神.树专题.公共节点.力扣.TreeNode;
import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

import java.awt.image.renderable.RenderableImage;

public class Solution {
    int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        help(root);
        return maxPath;
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        if(root.left != null && root.left.val == root.val)
            left = left + 1;
        else
            left = 0;
        if(root.right != null && root.right.val == root.val)
            right = right + 1;
        else
            right = 0;
        maxPath = Math.max(maxPath,left + right);
        return Math.max(left,right);
    }

}
