package 主要练习.树专题.视频.消息体处理.求二叉树的最大二叉子树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class getMaxSBT {
    public static ReturnData getMaxSearchBinaryTree(TreeNode root){
        if(root == null)
            return new ReturnData(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        ReturnData leftData = getMaxSearchBinaryTree(root.left);
        ReturnData rightData = getMaxSearchBinaryTree(root.right);
        if(leftData.root == root.left && rightData.root == root.right
                &&
                root.val > leftData.maxValue && root.val < rightData.minValue){
            int minValue = root.left == null ? root.val : leftData.minValue;
            int maxValue = root.right == null ? root.val : rightData.maxValue;
            return new ReturnData(rightData.size + leftData.size + 1,root,maxValue,minValue);
        }

        if(leftData.size > rightData.size)
            return leftData;
        else
            return rightData;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(16);
        root.right = new TreeNode(14);
        ReturnData tree = getMaxSearchBinaryTree(root);
        System.out.println(tree.root.val);
    }
}
class ReturnData{
    int size; //二叉树的大小即节点的个数
    TreeNode root; //此二叉搜索树的头节点
    int maxValue; // 此二叉搜索树的最大值
    int minValue;

    public ReturnData(int size, TreeNode root, int maxValue, int minValue) {
        this.size = size;
        this.root = root;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
