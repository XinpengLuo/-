package 自己写的排序专题;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int time = 0;
    List<Integer> res = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        help(root);
        int[] arr = new int[res.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = res.get(i);
        return arr;
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        int sum = left + right + root.val;
        map.put(sum,map.getOrDefault(sum, 0) + 1);
        int size = map.get(sum);
        if(size == time)
            res.add(sum);
        if(size > time){
            time = size;
            res.clear();
            res.add(sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        Solution solution = new Solution();
        int[] arr = solution.findFrequentTreeSum(root);
        System.out.println(Arrays.toString(arr));
    }
}