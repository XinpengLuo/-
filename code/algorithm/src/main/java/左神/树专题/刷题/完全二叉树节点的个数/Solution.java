package 左神.树专题.刷题.完全二叉树节点的个数;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = 0;
        TreeNode left = root.left;
        while (left != null){
            leftDepth++;
            left = left.left;
        }
        int rightDepth = 0;
        TreeNode right = root.right;
        while (right != null){
            rightDepth++;
            right = right.left;
        }
        if(leftDepth == rightDepth)
            return 1 + ((1 << leftDepth) - 1) + countNodes(root.right);
        return 1 + ((1 << rightDepth) - 1) + countNodes(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));
    }
}
