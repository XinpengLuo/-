package 主要练习.前缀树.连接词;
import java.util.*;

public class Solution {
    TrieNode root = new TrieNode();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (String word : words) {
            if(word.equals(""))
                continue;
            if(dfs(word,0))
                res.add(word);
            else
                insert(word);
        }
        return res;
    }
    public boolean dfs(String word, int i){
        if(i >= word.length())
             return true;
        TrieNode node = root;
        while (i < word.length()){
            int index = word.charAt(i) - 'a';
            if(node.next[index] == null)
                return false;
            node = node.next[index];
            if(node.end != 0 && dfs(word,i + 1))
                return true;
            i++;
        }
        return false;
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.end++;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        Solution solution = new Solution();
        System.out.println(solution.findAllConcatenatedWordsInADict(words));
    }
}
class TrieNode{
    TrieNode[] next;
    int end;
    public TrieNode(){
        next = new TrieNode[26];
        end = 0;
    }
}
