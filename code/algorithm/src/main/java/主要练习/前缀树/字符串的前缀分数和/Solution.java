package 主要练习.前缀树.字符串的前缀分数和;

public class Solution {
    TrieNode root = new TrieNode();

    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        for (String word : words) {
            buildTree(word);
        }
        for(int i = 0; i < words.length; i++){
            res[i] = search(words[i]);
        }
        return res;
    }
    public int search(String prefix){
        TrieNode temp = root;
        int sum = 0;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(temp.next[index] == null)
                return 0;
            temp = temp.next[index];
            sum += temp.path;
        }
        return sum;
    }
    public void buildTree(String s){
        TrieNode temp = root;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(temp.next[index] == null)
                temp.next[index] = new TrieNode();
            temp = temp.next[index];
            temp.path++;

        }
    }
}
class TrieNode{
    TrieNode[] next;
    int path;
    public TrieNode(){
        path = 0;
        next = new TrieNode[26];
    }
}