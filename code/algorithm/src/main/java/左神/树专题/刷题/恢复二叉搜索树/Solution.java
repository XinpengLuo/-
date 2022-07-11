package 左神.树专题.刷题.恢复二叉搜索树;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    List<TreeNode> list = new ArrayList<>();
    TreeNode pre;
    TreeNode x;
    TreeNode y;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inOrder(root);
        TreeNode x = null, y = null;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i).val > list.get(i + 1).val)
            {
                y = list.get(i + 1);
                if(x == null)
                    x = list.get(i);
            }
        }
        int val = y.val;
        y.val = x.val;
        x.val = val;
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    public void recoverTreeBetter(TreeNode root) {
        if(root == null)
            return;
        inOrderBetter(root);
        int val = y.val;
        y.val = x.val;
        x.val = val;
    }



    public void inOrderBetter(TreeNode root){
        if(root == null)
            return;
        inOrderBetter(root.left);
        if(pre != null){
            if(pre.val > root.val){
                y = root;
                if(x == null)
                    x = pre;
            }
        }
        pre = root;
        inOrderBetter(root.right);
    }
}
