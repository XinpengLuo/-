package 主要练习.前缀树.添加与搜索单词;

public class WordDictionary {
    WordNode root;
    public WordDictionary() {
        root = new WordNode();
    }

    public void addWord(String word) {
        WordNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if(node.next[index] == null)
                node.next[index] = new WordNode();
            node = node.next[index];
        }
        node.end++;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word, int index, WordNode node){
        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j = 0; j < node.next.length; j++){
                    if(node.next[j] != null){
                       boolean flag =  dfs(word,i + 1,node.next[j]);
                       if(flag)
                           return true;
                    }
                }
                return false;
            }
            else{
                int num = c - 'a';
                if(node.next[num] == null)
                    return false;
                node = node.next[num];
            }
        }
        return node.end > 0;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("b.."));
    }
}
class WordNode{
    WordNode[] next;
    int end;
    public WordNode(){
        next = new WordNode[26];
        end = 0;
    }
}