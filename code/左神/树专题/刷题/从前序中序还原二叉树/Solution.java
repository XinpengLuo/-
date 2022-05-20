package 左神.树专题.刷题.从前序中序还原二叉树;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length -1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftIndex = inStart;
        for(int i = inStart; i <= inEnd && inorder[i] != preorder[preStart]; i++)
            leftIndex = i + 1;
        root.left = build(preorder,preStart + 1,leftIndex - inStart + preStart,inorder,inStart,leftIndex - 1);
        root.right = build(preorder,leftIndex - inStart + preStart + 1,preEnd,inorder,leftIndex + 1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,17};
        int[] inOrder = {9,3,15,20,7};
        Solution solution = new Solution();
        solution.buildTree(preOrder,inOrder);
    }
}
