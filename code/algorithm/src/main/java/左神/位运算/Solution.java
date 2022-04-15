package 左神.位运算;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < total; i++){
            int temp = 0;
            for(int j = 0; j < n; j++){
                if(((i >> j) & 1) == 1){
                    temp |= nums[j];
                }
            }
            if(temp > max){
                max = temp;
                count = 1;
            }
            else if(temp == max)
                count++;
        }
        return count;
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while(size-- > 0){
                Node temp = queue.poll();
                tempList.add(temp.val);
               if(temp.children!= null && temp.children.size() != 0){
                   for (Node node : temp.children) {
                       queue.add(node);
                   }
               }
            }
            res.add(tempList);
        }
        return res;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

