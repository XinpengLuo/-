package 主要练习.暴力递归和动态规划.动态规划.刷题.打家劫舍系列;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.HashMap;

//打家劫舍1
public class Solution {
    public int rob(int[] nums) {
        return help(nums,0);
    }
    public int help(int[] nums, int index){
        if(index >= nums.length)
            return 0;
        return Math.max(nums[index] + help(nums,index + 2),help(nums,index + 1));
    }
    public int dpArr(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        for(int i = nums.length; i >= 0; i--){
            int a = i + 2 >= dp.length ? 0 : dp[i + 2];
            int b = i + 1 >= dp.length ? 0 : dp[i + 1];
            dp[i] = Math.max(nums[i] + a,b);
        }
        return dp[0];
    }
}
class Rob2{
    public int rob(int[] nums) {
        return Math.max(help(nums,0,nums.length - 1),help(nums,1,nums.length));
    }
    public int help(int[] nums, int index, int end){
        if(index >= end)
            return 0;
        return Math.max(nums[index] + help(nums,index + 2,end),help(nums,index + 1,end));
    }
    public int dp(int[] nums){
        //要头不要尾
        int[] dpHead = new int[nums.length];
        for(int i = dpHead.length - 2; i >= 0; i--)
            dpHead[i] = Math.max(nums[i] + getValue(dpHead,i + 2),getValue(dpHead,i + 1));
        int[] dpTail = new int[nums.length + 1];
        for(int i = dpTail.length - 2; i >= 1; i--)
            dpTail[i] = Math.max(nums[i] + getValue(dpTail,i + 2),getValue(dpTail,i + 1));
        return Math.max(dpHead[0],dpTail[1]);
    }
    public int getValue(int[] dp, int index){
        if(index >= dp.length)
            return 0;
        return dp[index];
    }
}
class Rob3{
    HashMap<TreeNode,Integer> hashMap = new HashMap<>();
    public int rob(TreeNode root) {
        return help(root);
    }
    public int help(TreeNode root){
        if(hashMap.containsKey(root))
            return hashMap.get(root);
        if(root == null)
            return 0;
        int money = 0,left = 0, right = 0;
        if(root.left != null)
        {
            left = 0;
            right = 0;
            if(hashMap.containsKey(root.left.left))
                left = hashMap.get(root.left.left);
            else
                {
                    left = help(root.left.left);
                    hashMap.put(root.left.left,left);
                }
            if(hashMap.containsKey(root.left.right))
                right = hashMap.get(root.left.right);
            else
            {
                right = help(root.left.right);
                hashMap.put(root.left.right,right);
            }
            money = money + left + right;
        }
        if(root.right != null)
        {
            left = 0;
            right = 0;
            if(hashMap.containsKey(root.right.left))
                left = hashMap.get(root.right.left);
            else
            {
                left = help(root.right.left);
                hashMap.put(root.right.left,left);
            }
            if(hashMap.containsKey(root.right.right))
                left = hashMap.get(root.right.right);
            else
            {
                right = help(root.right.right);
                hashMap.put(root.right.right,right);
            }
            money = money + left + right;
        }
        left = 0;
        right = 0;
        if(hashMap.containsKey(root.left))
            left = hashMap.get(root.left);
        else{
            left = help(root.left);
            hashMap.put(root.left,left);
        }
        if(hashMap.containsKey(root.right))
            right = hashMap.get(root.right);
        else{
            right = help(root.right);
            hashMap.put(root.right,right);
        }
        money = Math.max(root.val + money,left + right);
        return money;
    }
}