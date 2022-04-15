package 左神.树专题.刷题.寻找二叉树的叶子节点;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        while (root.left != null || root.right != null){
            help(root,temp);
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        temp.add(root.val);
        res.add(temp);
        return res;
    }
    public boolean help(TreeNode root, List<Integer> temp){
        if(root == null)
            return true;
        if(root.left == null && root.right == null){
            temp.add(root.val);
            return true;
        }
        if(help(root.left,temp))
            root.left = null;
        if(help(root.right,temp))
            root.right = null;
        return false;
    }
}
