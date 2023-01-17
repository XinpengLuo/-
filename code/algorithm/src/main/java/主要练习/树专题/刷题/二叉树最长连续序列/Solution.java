package 主要练习.树专题.刷题.二叉树最长连续序列;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class Solution {
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        return dfs(root,9);
    }
    public int dfs(TreeNode root, int preVal){
        if(root == null)
            return 0;
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        int res = Math.max(left,right) + 1;
        ans = Math.max(ans,res);
        if(root.val == preVal + 1)
            return res;
        return 0;
    }
}

