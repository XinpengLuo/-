package 主要练习.前缀树;

class Solution {
    TrieNode root = new TrieNode();
    public int countPrefixes(String[] words, String s) {
        buildTree(s);
        int count = 0;
        for(int i = 0; i < words.length; i++){
            TrieNode temp = root;
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++){
                int index = words[i].charAt(j) - 'a';
                if(temp.next[index] == null)
                {
                    flag = false;
                    break;
                }
                temp = temp.next[index];
            }
            if(flag)
                count++;
        }
        return count;
    }
    public void buildTree(String s){
        TrieNode temp = root;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            temp.next[index] = new TrieNode();
            temp = temp.next[index];
        }
    }

    public static void main(String[] args) {
        String[] words = {"a","b","c","ab","bc","abc"};
        Solution solution = new Solution();
        System.out.println(solution.countPrefixes(words, "abc"));
    }
}
class TrieNode{
    TrieNode[] next;
    public TrieNode(){
        next = new TrieNode[26];
    }
}