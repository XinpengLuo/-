package 左神.树专题.刷题.好叶子节点对的数量;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return count;
    }
    public List<Integer> dfs(TreeNode root, int distance){
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if(root.left == null && root.right == null)
        {
            res.add(1);
            return res;
        }
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (Integer l : left) {
            for (Integer r : right) {
                if(l + r <= distance)
                    count++;
            }
        }
        for (Integer l : left) {
            if(l + 1 > distance)
                continue;
            res.add(l + 1);
        }
        for (Integer r : right) {
            if(r + 1 > distance)
                continue;
            res.add(r + 1);
        }
        return res;
    }
}
