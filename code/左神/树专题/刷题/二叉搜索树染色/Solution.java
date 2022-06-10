package 左神.树专题.刷题.二叉搜索树染色;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    int index = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public int getNumber(TreeNode root, int[][] ops) {
        //0 --> 染成蓝色 1 --> 染成红色
        if(root == null)
            return 0;
        dfs(root);
        boolean[] flag = new boolean[map.size()];
        for (int[] op : ops) {
            int left = map.get(op[1]);
            int right = map.get(op[2]);
            Arrays.fill(flag,left,right + 1 , op[0] == 0 ? false : true);
        }
        int count = 0;
        for (boolean b : flag) {
            if(b)
                count++;
        }
        return count;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        map.put(root.val,index++);
        dfs(root.right);
    }
}
