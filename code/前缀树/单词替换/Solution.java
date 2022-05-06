package 前缀树.单词替换;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] split = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if(sb.length() > 0)
                sb.append(" ");
            sb.append(trie.searchWithPrefix(s));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public String searchWithPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.next[index] != null && node.next[index].word != null) //如果下一前缀不为空 且有以它为结尾的字符串 那么肯定最短 直接返回
               return node.next[index].word;
            if(node.next[index] == null)
                break;
            node = node.next[index];
        }
        return word;
    }
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.word = word;
    }
}
class TrieNode{
    TrieNode[] next;
    String word; //辅助变量 标记以它结尾的字符串是多少
    public TrieNode(){
        next = new TrieNode[26];
    }
}
