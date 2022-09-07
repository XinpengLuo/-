package 左神.树专题.刷题.寻找重复的子树;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    public String dfs(TreeNode root){
        if(root == null)
            return "_#";
        String temp = root.val + "#";
        temp += dfs(root.left) + dfs(root.right);
        if(!map.containsKey(temp))
            map.put(temp,1);
        else if(map.get(temp) != 2){
            res.add(root);
            map.put(temp,2);
        }
        return temp;
    }
}
