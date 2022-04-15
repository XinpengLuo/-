package 左神.并查集;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Node{}
public class UnionFindSet {
    private HashMap<Node,Node> fatherMap; //用于存放当前节点的代表节点
    private HashMap<Node,Integer> sizeMap; //用于存放当前节点所在集合的节点个数
    //初始化操作
    public UnionFindSet(List<Node> list){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node : list) {
            fatherMap.put(node,node); //一开始每个节点形成一个集合
            sizeMap.put(node,1);
        }
    }
    //找代表头节点的操作 迭代版本
    public Node findHead(Node node){
        if(node == null)
            return null;
        Stack<Node> stack = new Stack<>();
        Node parent = fatherMap.get(node);
        while (parent != node){
            stack.push(node);
            node = parent;
            parent = fatherMap.get(node);
        }
        while (!stack.isEmpty())
            fatherMap.put(stack.pop(),parent);
        return parent;
    }
    //找代表头节点的操作  递归版本
     public Node findHeadRcu(Node node){
        if(node == null)
            return null;
        Node father = fatherMap.get(node);
        if(father != node)
            father = findHeadRcu(father);
        fatherMap.put(node,father);
        return father;
     }
     //判断两个节点是否属于同集合
    public boolean isSameSize(Node node1, Node node2){
        return findHead(node1) == findHead(node2);
    }
    //将a所在的集合 和 b所在的集合进行合并
    public void UnionSet(Node node1, Node node2){
        if(node1 == null || node2 == null)
            return;
        Node head1 = findHead(node1);
        Node head2 = findHead(node2);
        if(head1 != head2){
            int size1 = sizeMap.get(head1);
            int size2 = sizeMap.get(head2);
            if(size1 <= size2){
                fatherMap.put(head1,head2);
                sizeMap.put(head2,size1 + size2);
            }
            else {
                fatherMap.put(head2,head1);
                sizeMap.put(head1,size1 + size2);
            }
        }
    }
}
class Island{
    public int countIsland(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1){
                    count++;
                    infect(matrix,i,j,r,c);
                }
            }
        }
        return count;
    }
    private void infect(int[][] m,int i,int j,int r,int c){
        if(i < 0 || i >= r || j < 0 || j >= c || m[i][j] != 1)
            return;
        m[i][j] = 2;
        infect(m,i + 1,j,r,c);
        infect(m,i,j + 1,r,c);
        infect(m,i - 1,j,r,c);
        infect(m,i,j - 1,r,c);
    }
}