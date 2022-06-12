package 前缀树.字符流;

class StreamChecker {
    TrieNode root;
    StringBuilder sb = new StringBuilder();
    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            buildTree(word);
        }
    }
    public void buildTree(String s){
        TrieNode temp = root;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(temp.next[c - 'a'] == null)
                temp.next[c - 'a'] = new TrieNode();
            temp = temp.next[c - 'a'];
        }
        temp.end++;
    }
    public boolean isPrefix(){
        TrieNode temp = root;
        for(int i = 0; i < sb.length(); i++){
            int index = sb.charAt(i) - 'a';
            if(temp.end > 0)
                return true;
            if(temp.next[index] == null)
                return false;
            temp = temp.next[index];
        }
        return temp.end > 0;
    }
    public boolean query(char letter) {
        sb.insert(0,letter);
        return isPrefix();
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