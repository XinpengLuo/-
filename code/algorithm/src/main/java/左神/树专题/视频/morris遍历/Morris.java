package 左神.树专题.视频.morris遍历;

import 左神.树专题.公共节点.力扣.TreeNode;

public class Morris  {
    public void morrisPre(TreeNode root){
        if(root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                //求左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null)
                    {
                        mostRight.right = cur;
                        //如果一个节点有左子树 那么会回到这个节点两次 那么再第一次时输出
                        System.out.println(cur.val + " ");
                        cur = cur.left;
                        continue;
                    }
                else
                    mostRight.right = null;
            }
            else //如果一个节点没有左子树那么他只会来这个节点一次
                System.out.println(cur.val + " ");
            cur = cur.right;
        }
    }
    public void morrisIn(TreeNode root){
        if(root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                //求左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null)
                {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else
                    mostRight.right = null;
            }
            System.out.println(cur.val + " ");
            cur = cur.right;
        }
    }
}
