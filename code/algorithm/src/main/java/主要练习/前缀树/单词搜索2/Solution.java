package 主要练习.前缀树.单词搜索2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Solution {
    TrieNode root;
    HashSet<String> set;
    public List<String> findWords(char[][] board, String[] words) {
        build(words);
        set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                dfs(board,i,j,root);
        }
        List<String> res= new ArrayList<>(set);
        return res;
    }
    public void dfs(char[][] board, int i, int j, TrieNode node){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#')
            return;
        int index = board[i][j] - 'a';
        node = node.next[index];
        if(node == null)
            return;
        if(node.end != 0)
            set.add(node.word);
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(board,i + 1,j,node);
        dfs(board,i - 1,j,node);
        dfs(board,i,j + 1,node);
        dfs(board,i,j - 1,node);
        board[i][j] = temp;
    }

    public void build(String[] words){
        root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.end++;
            node.word = word;
        }
    }
}
class TrieNode{
    int end;
    TrieNode[] next;
    String word;
    public TrieNode(){
        end = 0;
        next = new TrieNode[26];
        word = null;
    }
}
