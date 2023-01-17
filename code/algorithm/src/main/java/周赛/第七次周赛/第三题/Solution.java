package 周赛.第七次周赛.第三题;

import 主要练习.树专题.公共节点.力扣.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    HashMap<TreeNode,TreeNode> map = new HashMap<>(); //key --> son value --> father
    HashSet<Integer> visited = new HashSet<>();
    TreeNode startNode = null;
    StringBuilder ans = new StringBuilder();
    String s = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        addFather(root,null,startValue);
        help(startNode, destValue);
        return s;
    }
    public void addFather(TreeNode root, TreeNode father, int startValue){
        if(root == null)
            return;
        if(root.val == startValue)
            startNode = root;
        map.put(root,father);
        addFather(root.left,root,startValue);
        addFather(root.right,root,startValue);
    }
    public int help(TreeNode root, int targetValue){
        if(root == null || visited.contains(root.val))
            return 10000;
        if(root.val == targetValue)
        {
            if(s.equals(""))
                s = ans.toString();
            else
                s = ans.toString().length() < s.length() ? ans.toString() : s;
            return 0;
        }
        visited.add(root.val);
        int res = Integer.MAX_VALUE;
        ans.append('L');
        res = Math.min(res,help(root.left,targetValue));
        ans.deleteCharAt(ans.length() - 1);
        ans.append('R');
        res = Math.min(res,help(root.right,targetValue));
        ans.deleteCharAt(ans.length() - 1);
        ans.append('U');
        res = Math.min(res,help(map.get(root),targetValue));
        ans.deleteCharAt(ans.length() - 1);
        visited.remove(root.val);
        return res + 1;
    }

    public String beeter(TreeNode root, int startValue, int destValue){
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        travelToTarget(root,startValue,destValue,start,dest,new StringBuilder());
        if(start.length() == 0)
            return dest.toString();
        int index = 0;
        while (index < start.length() && index < dest.length() && start.charAt(index) == dest.charAt(index))
            index++;
        StringBuilder temp = new StringBuilder();
        for(int i = index; i < start.length(); i++)
            temp.append('U');
        temp.append(dest.subSequence(index,dest.length()));
        return temp.toString();
    }
    public void travelToTarget(TreeNode root, int startVal,int destVal, StringBuilder start, StringBuilder dest, StringBuilder temp){
        if(root == null)
            return;
        if(root.val == startVal)
            start.append(temp.toString());
        if(root.val == destVal)
            dest.append(temp.toString());
        temp.append("L");
        travelToTarget(root.left,startVal,destVal,start,dest,temp);
        temp.deleteCharAt(temp.length() - 1);
        temp.append("R");
        travelToTarget(root.right,startVal,destVal,start,dest,temp);
        temp.deleteCharAt(temp.length() - 1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(solution.getDirections(root, 3, 6));
        System.out.println(solution.beeter(root,3,5));
    }
}
