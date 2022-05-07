package 前缀树.搜索推荐系统;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        build(products);
        TrieNode node = root;
        boolean flag = false;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> temp = new ArrayList<>();
            int index = searchWord.charAt(i) - 'a';
            if(flag || node.next[index] == null)
                {
                    flag = true;
                    res.add(temp);
                    continue;
                }
            node = node.next[index];
            int size = node.words.size();
            for(int j = 0; j < 3 && j < size; j++)
                temp.add(node.words.poll());
            res.add(temp);
        }
        return res;
    }
    public void build(String[] products){
        root = new TrieNode();
        for (String product : products) {
            TrieNode node = root;
            for (int i = 0; i < product.length(); i++) {
                int index = product.charAt(i) - 'a';
                if(node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
                node.words.add(product);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        solution.suggestedProducts(products,"mouse");
    }
}
class TrieNode{
    TrieNode[] next;
    PriorityQueue<String> words;
    public TrieNode(){
        next = new TrieNode[26];
        words = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t1.compareTo(t2);
            }
        });
    }
}
