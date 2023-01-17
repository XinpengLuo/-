package 面试真题.腾讯二叉树赋值;

import 主要练习.树专题.公共节点.力扣.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param tree TreeNode类
     * @return int整型
     */
    public int getTreeSum (TreeNode tree) {
        // write code here
        long left = countChildren(tree.left);
        long right = countChildren(tree.right);
        int mod = 1000000007;
        System.out.println(left + " " + right);
        long val =  left * right / getGcd(left, right) % mod;
        return (int)((2 * val + 1) % mod);
    }
    public long getGcd(long x, long y) {
        return y == 0 ? x : getGcd(y, x % y);
    }
    public long countChildren(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countChildren(root.left) + countChildren(root.right);
    }
}