package 左神.树专题.刷题.二叉树染色;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.HashMap;

public class Solution {
    int num = 0;
    HashMap<TreeNode, HashMap<Integer,Integer>> map = new HashMap<>();
    public int maxValue(TreeNode root, int k) {
        num = k;
        return dfs(root,k);
    }
    public int dfs(TreeNode root,int k){
        if(root == null)
            return 0;
        int left = 0;
        int right = 0;
        if(map.containsKey(root.left) && map.get(root.left).containsKey(num))
            left = map.get(root.left).get(num);
        else{
            left = dfs(root.left,num);
            if(!map.containsKey(root.left))
                map.put(root.left,new HashMap<>());
            map.get(root.left).put(num,left);
        }
        if(map.containsKey(root.right) && map.get(root.right).containsKey(num))
            right = map.get(root.right).get(num);
        else{
            right = dfs(root.right,num);
            if(!map.containsKey(root.right))
                map.put(root.right,new HashMap<>());
            map.get(root.right).put(num,right);
        }
        int res = left + right;
        for(int i = 0; i <= k - 1; i++){
            int l = 0;
            int r = 0;
            if(map.containsKey(root.left) && map.get(root.left).containsKey(i))
                l = map.get(root.left).get(i);
            else{
                l = dfs(root.left,i);
                if(!map.containsKey(root.left))
                    map.put(root.left,new HashMap<>());
                map.get(root.left).put(i,l);
            }
            if(map.containsKey(root.right) && map.get(root.right).containsKey(k - 1 - i))
                r = map.get(root.right).get(k - 1 - i);
            else{
                r = dfs(root.right,k - 1 - i);
                if(!map.containsKey(root.right))
                    map.put(root.right,new HashMap<>());
                map.get(root.right).put(k - 1 - i,r);
            }
            res = Math.max(res,root.val + l + r);
        }
        return res;
    }
}
