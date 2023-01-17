package 主要练习.树专题.视频.消息体处理.求二叉树的最大值和最小值;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class MaxAndMinValue {
    public static ReturnType getMaxAndMin(TreeNode root){
        if(root == null)
            return new ReturnType(Integer.MIN_VALUE,Integer.MAX_VALUE);
        TreeNode left = root.left;
        ReturnType leftType = getMaxAndMin(left);
        TreeNode right = root.right;
        ReturnType rightType = getMaxAndMin(right);
        int maxValue = Math.max(Math.max(leftType.maxValue,rightType.maxValue),root.val);
        int minValue = Math.min(Math.min(leftType.minValue,rightType.minValue),root.val);
        return new ReturnType(maxValue,minValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(23);
        root.left = new TreeNode(3);
        root.right = new TreeNode(12);
        ReturnType type = getMaxAndMin(root);
        System.out.println(type.maxValue);
        System.out.println(type.minValue);
    }
}
class ReturnType{
    int maxValue;
    int minValue;
    public ReturnType(int maxValue, int minValue){
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}