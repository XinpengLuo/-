package 主要练习.树专题.视频.树的判断.完全二叉树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    //判断是否是完全二叉树
    public static boolean isCBTree(TreeNode treeNode){
        if(treeNode == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        TreeNode temp = null;
        boolean flag = false;
        while (!queue.isEmpty()){
            temp = queue.poll();
            if((flag && (temp.left != null || temp.right != null)) ||( temp.right != null && temp.left == null)){
                return false;
            }
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            if(!flag && (temp.left == null || temp.right == null)) //(left == null || right == null)
                flag = true;
        }
        return true;
    }

    //求完全二叉树的节点个数 全意是以当前节点为头节点的完全二叉树的节点个数
    public static int countNumber(TreeNode node, int level, int h){
        if(level == h) // (node.left == null && node.right == null )
            return 1;
        if(getMaxLevel(node.right,level + 1) != h)
            return 1 << (h - level) + countNumber(node.right,level + 1,h);
        else
            return 1 << (h - level - 1) + countNumber(node.left,level + 1,h);

    }
    //重载下
    public static int countNumber(TreeNode node){
       return countNumber(node, 1 , getMaxLevel(node,1));
    }
    public static int getMaxLevel(TreeNode node,int level){
        if(node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
