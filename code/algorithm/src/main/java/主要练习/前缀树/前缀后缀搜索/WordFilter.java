package 主要练习.前缀树.前缀后缀搜索;

import java.util.*;

class WordFilter {
    TrieNode preRoot;
    TrieNode suffRoot;
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        preRoot = new TrieNode();
        suffRoot = new TrieNode();
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }
        for (String word : words) {
            TrieNode preTemp = preRoot;
            TrieNode suffTemp = suffRoot;
            for(int i = 0; i < word.length(); i++){
                int preIndex = word.charAt(i) - 'a';
                int suffIndex = word.charAt(word.length() - 1 - i) - 'a';
                if(preTemp.next[preIndex] == null)
                    preTemp.next[preIndex] = new TrieNode();
                if(suffTemp.next[suffIndex] == null)
                    suffTemp.next[suffIndex] = new TrieNode();
                preTemp = preTemp.next[preIndex];
                suffTemp = suffTemp.next[suffIndex];
                preTemp.end.add(word);
                suffTemp.end.add(word);
             }
        }
    }

    public int f(String pref, String suff) {
        HashSet<String> preSearch = search(pref,true);
        HashSet<String> suffSearch = search(new StringBuilder(suff).reverse().toString(),false);
        if(preSearch == null || suffSearch == null)
            return -1;
        int res = -1;
        for (String s : preSearch) {
            if(suffSearch.contains(s)){
                res = Math.max(res,map.get(s));
            }
        }
        return res;
    }
    //true --> 前缀搜索 false --> 后缀搜索
    public HashSet<String> search(String fix, boolean flag){
        TrieNode temp = flag ? preRoot : suffRoot;
        for(int i = 0; i < fix.length(); i++){
            int index = fix.charAt(i) - 'a';
            if(temp.next[index] == null)
                return null;
            temp = temp.next[index];
        }
        return temp.end.isEmpty() ? null : temp.end;
    }

    public static void main(String[] args) {
        String[] words = {"abbba","abba"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("ab", "ba"));
    }
}
class TrieNode{
    TrieNode next[];
    HashSet<String> end;
    public TrieNode(){
        next = new TrieNode[26];
        end = new HashSet<>();
    }
}