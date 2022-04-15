package 左神.树专题.视频.求树的后继节点;

public class NextNodeTree {
    public static Node getNextNode(Node node){
        if(node.right != null){
            node = node.right;
            while (node.left != null)
                node =  node.left;
            return node;
        }
        else {
            Node parent = node.parent;
            while (parent != null && parent.left != node)
            {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    public static Node getPreNode(Node node){
        if(node.left != null){
            node = node.left;
            while (node.right != null)
                node = node.left;
            return node;
        }
        else{
            Node parent = node.parent;
            while (parent != null && parent.right != node)
            {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
class Node{
    Node right;
    Node parent;
    Node left;
    int val;
    public Node(int val){
        this.val = val;
    }
}