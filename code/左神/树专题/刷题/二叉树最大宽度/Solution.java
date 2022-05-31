package 左神.树专题.刷题.二叉树最大宽度;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int res = 0;
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>(); //深度 --> 起始位置
        dfs(root,map,0,0);
        return res;
    }
    public void dfs(TreeNode root, HashMap<Integer,Integer> map, int depth, int index){
        if(root == null)
            return;
        if(!map.containsKey(depth))
            map.put(depth,index);
        res = Math.max(res, index - map.get(depth) + 1);
        dfs(root.left,map,depth + 1, index * 2);
        dfs(root.right,map,depth + 1,index * 2 + 1);
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(9);
        Solution solution = new Solution();
        System.out.println(solution.widthOfBinaryTree(treeNode));
    }
}
