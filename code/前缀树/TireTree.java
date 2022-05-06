package 前缀树;

import 左神.树专题.公共节点.力扣.TreeNode;

public class TireTree {
    TireNode root = new TireNode();
    public boolean search(String word){
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int temp = word.charAt(i) - 'a';
            if(node.children[temp] == null)
                return false;
            node = node.children[temp];
        }
        return node.end > 0;
    }
    public void delete(String word){
        if(!search(word))
            return;
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index].path == 1)
                {
                    node.children[index] = null;
                    return;
                }
            node.children[index].path--;
            node = node.children[index];
        }
        node.end--;
    }
    public boolean isStartWith(String prefix){
        TireNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int temp = prefix.charAt(i) - 'a';
            if(node.children[temp] == null)
                return false;
            node = node.children[temp];
        }
        return true;
    }
    public void insert(String word){
        char[] chars = word.toCharArray();
        TireNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int temp = chars[i] - 'a';
            if(node.children[temp] == null)
                node.children[temp] = new TireNode();
            node = node.children[temp];
            node.path++;
        }
        node.end++;
    }
}
class TireNode{
    int path; //代表有多少次滑过它
    int end; //代表多少次以这个节点结尾
    TireNode[] children;
    public TireNode(){
        path = 0;
        end = 0;
        children = new TireNode[26];
    }
}
