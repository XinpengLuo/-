package 左神.树专题.刷题.多叉树的深度;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

public class Solution {//多叉树的深度

    public int calculate(String s) {
        return 1 << s.length();
    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int maxDep = 0;
        for (Node child : root.children) {
            maxDep = Math.max(maxDepth(child),maxDep);
        }
        return maxDep + 1;
    }

}
