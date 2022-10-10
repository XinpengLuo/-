package 左神.数组和矩阵.刷题.神策面试;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

public class Solution {
    //二叉树 按照行输出 交替逆序输出
    public void printTree(TreeNode root){
        if(root == null)
            return;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            res.add(list);
        }
        for(int i = 0; i < res.size(); i++){
            List<Integer> temp = res.get(i);
            if(i % 2 != 0)
                Collections.reverse(temp);
            for (Integer val : temp) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    //字符串 最多删除一个字符 回文串
    public boolean isPara(String s){
        return isPara(s,0,s.length() - 1,false);
    }
    public boolean isPara(String s, int i, int j, boolean flag){
        if(i > j)
            return true;
        if(s.charAt(i) == s.charAt(j))
            return isPara(s,i + 1, j - 1,flag);
        if(flag)
            return false;
        return isPara(s,i,j - 1, !flag) || isPara(s,i + 1, j ,!flag);
    }

    //数组 数值k 后面k个数字移动到前面
    public void moveArr(int[] arr, int k){
        reverse(arr,0,arr.length - 1);
        reverse(arr,0, k - 1);
        reverse(arr,k,arr.length - 1);
    }
    public void reverse(int[] arr, int i, int j){
        while (i < j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1 2 3 4 5 6 -->  5 6 1 2 3 4
        //6 5 4 3 2 1 -->

        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // --> {5,6,3,4,1,2}
        //5 6 1 2 3 4
        solution.moveArr(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
