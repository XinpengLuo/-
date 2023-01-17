package 主要练习.树专题.刷题.反转二叉树的奇数层;

import 主要练习.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

import java.util.*;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null)
            return root;
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        list.add(rootList);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            List<TreeNode> temp = new ArrayList<>();
            while (size-- > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    temp.add(poll.left);
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    temp.add(poll.right);
                    queue.add(poll.right);
                }
            }
            if(!temp.isEmpty()) {
                if (depth % 2 != 0)
                    Collections.reverse(temp);
                list.add(temp);
            }
        }
        TreeNode node = list.get(0).get(0);
        for(int i = 1; i < list.size(); i++){
            for(int j = 0; j < list.get(i - 1).size(); j++){
                list.get(i - 1).get(j).left = list.get(i).get(j * 2);
                list.get(i - 1).get(j).right = list.get(i).get(j * 2 + 1);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = GenerateClass.generateTree("2,3,5,8,13,21,34,null,null,null,null,null,null,null,null");
        System.out.println(solution.reverseOddLevels(root));
    }
}
