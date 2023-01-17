package 主要练习.字符串.从叶节点开始的最小字符串;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class Solution {
    String pre = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return pre;
    }
    public void dfs(TreeNode root,StringBuilder stringBuilder){
        if(root == null)
            return;
        stringBuilder.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            stringBuilder.reverse();
            if(pre == null)
                pre = stringBuilder.toString();
            else if(stringBuilder.toString().compareTo(pre) == -1)
                    pre = stringBuilder.toString();
            stringBuilder.reverse();
        }

        dfs(root.left,stringBuilder);
        dfs(root.right,stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
