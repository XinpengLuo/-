package 左神.树专题.刷题.数组转二叉搜索树;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length - 1);
    }
    public TreeNode help(int[] nums, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(nums[(left + right) / 2]);
        root.left = help(nums,left,(left + right) / 2 - 1);
        root.right = help(nums,(left + right) / 2 + 1,right);
        return root;
    }
}
