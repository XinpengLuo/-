package 主要练习.树专题.刷题.数组构建树;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    public static TreeNode buildTreeByArr(int[] arr, int index){
        if(index >= arr.length)
            return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = buildTreeByArr(arr,index * 2  + 1);
        root.right = buildTreeByArr(arr, index * 2 + 2);
        return root;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,0,0,0,1};
        int[] arr2 = {1,0,0,1,1};
        Solution solution = new Solution();
        solution.dfs(0,0,arr1,arr2);
        System.out.println(solution.res);
    }

    int res = 0;
    public int findLength(int[] nums1, int[] nums2) {
        return dp(nums1,nums2);
    }
    public int dfs(int i, int j, int[] nums1, int[] nums2){
        if(i >= nums1.length || j >= nums2.length)
            return 0;
        System.out.println(i + " " + j);
        if(nums1[i] == nums2[j]) {
            int temp = 1 + dfs(i + 1, j + 1, nums1, nums2);
            res = Math.max(res,temp);
            return temp;
        }
        int temp =  Math.max(dfs(i + 1,j, nums1,nums2), dfs(i, j + 1, nums1, nums2));
        res = Math.max(res,temp);
        return temp;
    }
    public int dp(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

}
