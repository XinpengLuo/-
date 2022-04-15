package 左神.树专题.刷题.两数之和;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        int left = 0, right = list.size() - 1;
        while (left < right){
            int val = list.get(left).val + list.get(right).val;
            if(val == k)
                return true;
            else if(val > k)
                right--;
            else
                left++;
        }
        return false;
    }
    public void inOrder(TreeNode root,List<TreeNode> list){
        if(root == null)
            return;
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }
}
