package 左神.树专题.视频.消息体处理.求二叉树的最大路径和;

import 左神.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

public class getMaxSumPath {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        help(root);
        return maxSum;
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        int sum = left + right + root.val;
        int leftSum = left + root.val;
        int rightSum = right + root.val;
        maxSum = Math.max(Math.max(Math.max(sum,leftSum),rightSum),maxSum);
        maxSum = Math.max(maxSum,root.val);
        return Math.max(Math.max(left,right) + root.val,root.val);
    }

    public static void main(String[] args) {
        TreeNode root = GenerateClass.generateTree("-10,9,20,null,null,15,7,null,null,null,null");
        getMaxSumPath test = new getMaxSumPath();
        System.out.println(test.maxPathSum(root));
    }
}

