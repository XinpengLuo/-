package 左神.树专题.刷题.新的刷题集合;

import 左神.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

import java.util.HashMap;

public class Solution {
    int count = 0;
    int value = 0;
    //二叉搜素树第k小
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallesthelp(root);
        return value;
    }
    public void kthSmallesthelp(TreeNode root) {
        if(root == null)
            return;
        kthSmallesthelp(root.left);
        count--;
        if(count == 0){
            value = root.val;
        }
        kthSmallesthelp(root.right);
    }

    //二叉搜索树转单链表
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null)
            temp = temp.left;
        convertBiNodeHelp(root);
        return temp;
    }
    public void convertBiNodeHelp(TreeNode root){
        if(root == null)
            return;
        convertBiNodeHelp(root.left);
        root.left = null;
        if(pre != null)
            pre.right = root;
        pre = root;
        convertBiNodeHelp(root.right);
    }

    //二叉搜索树的最小绝对差
    int minMun = Integer.MAX_VALUE;
    int preValue = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        getMinimumDifferenceHelp(root);
        return minMun;
    }
    public void getMinimumDifferenceHelp(TreeNode root){
        if(root == null)
            return;
        getMinimumDifferenceHelp(root.left);
        int curDifValue = Math.abs(root.val - preValue);
        minMun = Math.min(curDifValue,minMun);
        preValue = root.val;
        getMinimumDifferenceHelp(root.right);
    }

    //翻转等价二叉树
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
    //修剪二叉搜索树
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        if(root.val < low) //如果比规定的最小还要小 那么就返回右节点 再进行修剪
            return trimBST(root.right,low,high);
        if(root.val > high)
            return trimBST(root.left,low,high);
        //到这里表示当前节点满足区间 再去修剪其左右
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

    //最小高度树
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelp(nums,0,nums.length - 1);
    }
    public TreeNode sortedArrayToBSTHelp(int[] nums,int left,int right){
        if(left > right)
            return null;
        int index = (left + right) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = sortedArrayToBSTHelp(nums,left,index - 1);
        root.right = sortedArrayToBSTHelp(nums,index + 1,right);
        return root;
    }

    //分裂二叉树的最大乘积
    Double maxSum = Double.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        Double allSum = getAllSum(root);
        maxProductHelp(root,allSum);
        return (int)(maxSum % (int)(1e9 + 7));
    }
    public void maxProductHelp(TreeNode root, Double allSum){
        if(root == null)
            return;
        Double leftSum = getAllSum(root);
        Double rightSum = allSum - leftSum;
        maxSum = Math.max(leftSum * rightSum,maxSum);
        maxProductHelp(root.left,allSum);
        maxProductHelp(root.right,allSum);
    }
    HashMap<TreeNode,Double> hashMap = new HashMap<>();
    public Double getAllSum(TreeNode root){
        if(root == null)
            return 0.0;
        if(hashMap.containsKey(root))
            return hashMap.get(root);
        Double sum = Double.valueOf(root.val);
        Double sumLeft = 0.0;
        Double sumRight = 0.0;
        if(hashMap.containsKey(root.left))
            sumLeft = hashMap.get(root.left);
        else
        {
            sumLeft = getAllSum(root.left);
            hashMap.put(root.left,sumLeft);
        }
        if(hashMap.containsKey(root.right))
            sumRight = hashMap.get(root.right);
        else
        {
            sumRight = getAllSum(root.right);
            hashMap.put(root.right,sumRight);
        }
        sum = sumLeft + sumRight + sum;
        hashMap.put(root,sum);
        return sum;
    }

    //叶子相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafValue(root1).equals(leafValue(root2));
    }
    public String leafValue(TreeNode root){
        if(root == null)
            return "";
        String val = "";
        if(root.left == null && root.right == null)
            val += root.val;
        return val + leafValue(root.left) + leafValue(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = GenerateClass.generateTree("1,null,5,3,null,null,null");
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(root));
    }
}
