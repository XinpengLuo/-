package 左神.单词频率;

import 左神.树专题.视频.前缀树.Trie;

import java.security.PublicKey;
import java.util.*;

public class Solution {
}
class WordsFrequency {
    TrieNode root;
    public WordsFrequency(String[] book) {
        root = new TrieNode();
        for (String s : book) {
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if(temp.next[index] == null)
                    temp.next[index] = new TrieNode();
                temp = temp.next[index];
            }
            temp.end++;
        }
    }

    public int get(String word) {
       TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.next[index] == null)
                return 0;
            temp = temp.next[index];
        }
        return temp.end;
    }

    public static void main(String[] args) {
        String[] book = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(book);
        System.out.println(wordsFrequency.get("have"));
    }
}
class WordsFrequencyHash {
    HashMap<String,Integer> map = new HashMap<>();
    public WordsFrequencyHash(String[] book) {
        for (String s : book) {
            map.put(s,map.getOrDefault(s,0) + 1);
        }
    }

    public int get(String word) {
        return map.get(word);
    }
}

class TrieNode{
    int end = 0;
    TrieNode[] next;
    public TrieNode(){
        next = new TrieNode[26];
    }
}