package 左神.字符串.替换字符串中的括号内容;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++)
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(c != '('){
                sb.append(c);
                index++;
                continue;
            }
            String temp = "";
            index++;
            while(s.charAt(index) != ')'){
                temp += s.charAt(index);
                index++;
            }
            sb.append(map.getOrDefault(temp,"?"));
            index++;

        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;
        int index = 0;
        String[] split = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        index++;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0)
            {
                TreeNode temp = queue.poll();
                temp.left = split[index].equals("_") ? null : new TreeNode(Integer.parseInt(split[index]));
                index++;
                if(temp.left != null)
                    queue.add(temp.left);
                temp.right = split[index].equals("_") ? null : new TreeNode(Integer.parseInt(split[index]));
                index++;
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1#2#3#_#_#4#5#_#_#_#_#";
        System.out.println(solution.deserialize(s));
    }
}