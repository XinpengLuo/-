package 主要练习.树专题.视频.树的判断.搜索二叉树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.Stack;

public class SearchTree {
    public static boolean isValidBST(TreeNode root) {
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            long val = Long.MIN_VALUE;
            while (!stack.isEmpty() || root != null){
                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    if(val > root.val)
                        return false;
                    val = root.val;
                    root = root.right;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        if(isValidBST(root))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
