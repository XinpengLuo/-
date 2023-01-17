package 主要练习.树专题.刷题.Moris遍历;

import 主要练习.树专题.公共节点.力扣.TreeNode;

public class Solution {
    public void morris(TreeNode root){
        if(root == null)
            return;
        TreeNode cur = root;
        while (cur != null){
            TreeNode mostRight = cur.left;
            if(mostRight != null){
                //找到左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else
                    mostRight.right = null;
            }
            cur = cur.right;
        }
    }
    //morris版本的先序遍历
    public void morrisPre(TreeNode root){
        if(root == null)
            return;
        TreeNode cur = root;
        while (cur != null){
            TreeNode mostRight = cur.left;
            if(mostRight != null){
                //找到左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else
                    mostRight.right = null;
            }
            else
                System.out.println(cur.val);
            cur = cur.right;
        }
    }
    //morris版本的中序遍历
    public void morrisIn(TreeNode root){
        if(root == null)
            return;
        TreeNode cur = root;
        while (cur != null){
            TreeNode mostRight = cur.left;
            if(mostRight != null){
                //找到左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    mostRight.right = null;
                    System.out.println(cur.val);
                }
            }
            else
                System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        TreeNode cur = root;
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        while (cur != null){
            TreeNode mostRight = cur.left;
            if(cur.left != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    if(pre != null){
                        if(pre.val > cur.val){
                            y = cur;
                            if(x == null)
                                x = pre;
                        }
                    }
                    pre = cur;
                    mostRight.right = null;
                }
            }
            else{
                if(pre != null){
                    if(pre.val > cur.val){
                        y = cur;
                        if(x == null)
                            x = pre;
                    }
                }
                pre = cur;
            }
            cur = cur.right;
        }
        int val = x.val;
        x.val = y.val;
        y.val = val;
    }
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}
