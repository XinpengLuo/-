package 左神.树专题.刷题.树中距离之和;

import java.util.*;

public class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(x < y)
                continue;
            edges[i][0] = y;
            edges[i][1] = x;
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        HashMap<Integer,Node> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            Node parentNode = map.getOrDefault(parent,new Node(parent));
            Node childNode = map.getOrDefault(child,new Node(child));
            parentNode.children.add(childNode);
            map.put(parent,parentNode);
            map.put(child,childNode);
        }
        Node root = map.get(0);
        int[] res = new int[n];
        return res;
    }
    public int dfs(Node root, int index, int[] res){
        if(root == null)
            return 0;
        int sum = 0;
        for(int i = 0; i < root.children.size(); i++)
            sum += dfs(root.children.get(i),index + i + 1, res);
        res[index] = sum;
        return sum + 1;
    }

}
class Node{
    int val;
    List<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<>();
    }
}
