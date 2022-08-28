package 左神.树专题.刷题.感染二叉树需要的总时间;

import com.sun.source.tree.Tree;
import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    HashMap<TreeNode,TreeNode> map = new HashMap<>();
    HashSet<TreeNode> set = new HashSet<>();
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        getFather(root,null,start);
        return dfs(startNode) - 1;
    }
    public int dfs(TreeNode node){

        if(node == null || set.contains(node))
            return 0;
        set.add(node);
        int left = dfs(node.left);
        int right = dfs(node.right);
        int parent = dfs(map.get(node));
        System.out.println(left + " " + right + " " + parent);
        return 1 + Math.max(Math.max(left,right),parent);
    }
    public void getFather(TreeNode root, TreeNode pre, int start){
        if(root == null)
            return;
        map.put(root,pre);
        if(root.val == start)
            startNode = root;
        getFather(root.left,root,start);
        getFather(root.right,root,start);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.amountOfTime(root, 3));
    }
}
