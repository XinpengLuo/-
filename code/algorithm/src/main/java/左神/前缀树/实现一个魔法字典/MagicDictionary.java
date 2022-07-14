package 左神.前缀树.实现一个魔法字典;

class MagicDictionary {
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if(node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.word = s;
        }
    }

    public boolean search(String searchWord) {
        return searchDFS(searchWord,0,root,true);
    }
    //题目要求必须替换一个字符
    public boolean searchDFS(String searchWord, int index, TrieNode node, boolean flag){
        for(int i = index; i < searchWord.length(); i++){
            int num = searchWord.charAt(i) - 'a';
            //如果有替换的机会先替换一遍
            if(flag){
                for(int j = 0; j < node.next.length; j++){
                    if(node.next[j] != null){
                        boolean isSearch = searchDFS(searchWord, i + 1,node.next[j],false);
                        if(isSearch)
                            return true;
                    }
                }
            }
            //没机会了再走常规的
            if(node.next[num] == null)
                return false;
            node = node.next[num];
        }
        //这里第三个条件意思是搜索的word必须和原来的word不一样
        return node.word != null  && flag == false && !node.word.equals(searchWord);
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] words = {"hello","leetcode"};
        magicDictionary.buildDict(words);
        System.out.println(magicDictionary.search("hello"));

    }
}
class TrieNode{
    TrieNode[] next;
    String word;
    public TrieNode(){
        next = new TrieNode[26];
        word = null;
    }
}