package 面试真题.构建所有的二叉树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {

    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        int n = preOrder.size();
        List<TreeNode> help = help(preOrder, inOrder, 0, n - 1, 0, n - 1);
        System.out.println(help.size());
        ArrayList<TreeNode> buildTree = buildTree(preOrder,0,n - 1,inOrder,0,n - 1);
        return buildTree;
    }
    //1 1 2     1 2 1
    public List<TreeNode> help(List<Integer> preOrder, List<Integer> inOrder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
        {
            ArrayList<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        //1 3 4  3 1 4
        List<TreeNode> res = new ArrayList<>();
        int rootVal = preOrder.get(preStart);
        for(int i = inStart; i <= inEnd; i++){
            if(inOrder.get(i) == rootVal){
                int len = i - inStart;
                List<TreeNode> left = help(preOrder,inOrder,preStart + 1, preStart + len, inStart, inStart + len - 1);
                List<TreeNode> right = help(preOrder,inOrder,preStart + 1 + len, preEnd, inStart + len + 1, inEnd);
                for(int j = 0; j < left.size(); j++)
                    for(int k = 0; k < right.size(); k++){
                        TreeNode root = new TreeNode(rootVal);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        res.add(root);
                    }

            }
        }
        return res;
    }



    ArrayList<TreeNode> buildTree(ArrayList<Integer> preOrder, int preStart, int preEnd,
                                  ArrayList<Integer> inOrder, int inStart, int inEnd) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (preStart > preEnd || inStart > inEnd) {
            res.add(null);
            return res;
        }
        int rootVal = preOrder.get(preStart);
        ArrayList<Integer> indexs = new ArrayList<>();
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i) == rootVal) {
                indexs.add(i);
            }
        }
        for (Integer index : indexs) {
            ArrayList<TreeNode> lefts = buildTree(preOrder, preStart + 1, preStart + index - inStart,
                    inOrder, inStart, index - 1);
            ArrayList<TreeNode> rights = buildTree(preOrder, preStart + index - inStart + 1, preEnd,
                    inOrder, index + 1, inEnd);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }




    public int minOperations(String[] logs) {
        int count = 0;
        for(int i = 0; i < logs.length; i++){
            String temp = logs[i];
            if(temp.equals("./"))
                continue;
            if(temp.equals("../"))
                count = count == 0 ? 0 : count - 1;
            else
                count++;
        }
        return Math.abs(count);
    }



    public static void main(String[] args) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        pre.add(1);
        pre.add(3);
        pre.add(2);
        in.add(3);
        in.add(2);
        in.add(1);
        Solution solution = new Solution();
        ArrayList<TreeNode> binaryTrees = solution.getBinaryTrees(pre, in);
        for (TreeNode binaryTree : binaryTrees) {
            System.out.println(binaryTree);
        }

    }
}
