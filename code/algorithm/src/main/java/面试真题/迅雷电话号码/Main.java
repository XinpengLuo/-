package 面试真题.迅雷电话号码;


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){
            int len = scanner.nextInt();
            String[] strs = new String[len];
            for(int i = 0; i < len; i++)
                strs[i] = scanner.next();
            Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
            Tree tree = new Tree();
            tree.buildTree(strs[0]);
            boolean flag = true;
            for(int i = 1; i < strs.length; i++){
                if(tree.search(strs[i]) != 0){
                    flag = false;
                    break;
                }
                tree.buildTree(strs[i]);
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
class Tree{
    TrieNode root = new TrieNode();
    public void buildTree(String s){
        TrieNode temp = root;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - '0';
            if(temp.next[index] == null)
                temp.next[index] = new TrieNode();
            temp = temp.next[index];
            temp.path++;
        }
    }
    public int search(String prefix){
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - '0';
            if(temp.next[index] == null)
                return 0;
            temp = temp.next[index];
        }
        return temp.path;
    }
}
class TrieNode{
    int path;
    TrieNode[] next;
    public TrieNode(){
        path = 0;
        next = new TrieNode[10];
    }
}
