package 左神.树专题.刷题.二叉树的垂序遍历;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;
class Node{
    int val;
    int level;
    public Node(int val, int level){
        this.val = val;
        this.level = level;
    }
}
public class Solution {
    HashMap<Integer,List<Node>> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,0);
        for(int i = min; i <= max; i++) {
            List<Node> temp = map.get(i);
            Collections.sort(temp, new Comparator<Node>() {
                @Override
                public int compare(Node t1, Node t2) {
                    if(t1.level == t2.level)
                        return t1.val - t2.val;
                    return t1.level - t2.level;
                }
            });
            List<Integer> list = new ArrayList<>();
            for (Node node : temp) {
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
    public void dfs(TreeNode root, int index, int level){
        if(root == null)
            return;
        if(!map.containsKey(index))
        {
            List<Node> temp = new ArrayList<>();
            map.put(index,temp);
        }
        List<Node> list = map.get(index);
        min = Math.min(min,index);
        max = Math.max(max,index);
        dfs(root.left, index - 1,level + 1);
        Node node = new Node(root.val,level);
        list.add(node);
        dfs(root.right,index + 1, level + 1);
    }
}
