package 左神.树专题.视频.前缀树;

class TrieNode{
    int path; //表示有多少个字符串经历过这个节点
    int end; //表示有多少个字符串以此节点结尾
    TrieNode[] next; //用数组的形式来表示后面的a-z路径 如果不为空代表有
    public TrieNode(){
        path = 0;
        end = 0;
        next = new TrieNode[26];
    }
}
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    //传入一个字符串 构成新的路径
    public void insert(String word){
        if(word.isEmpty())
            return;
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char aChar : chars) {
            index = aChar - 'a';
            if(node.next[index] == null){
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.path++;
        }
        node.end++;
    }
    //传入一个字符串 看看这颗前缀树里出现了几次
    public int search(String word){
        if(word.isEmpty())
            return 0;
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char aChar : chars) {
            index = aChar - 'a';
            if(node.next[index] == null)
                return 0;
            node = node.next[index];
        }
        return node.end;
    }
    //删除一个字符串 注意删除后path = 0和不为0 的区别
    public void delete(String word){
        if(search(word) != 0){
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (char aChar : chars) {
                index = aChar - 'a';
                if(--node.next[index].path == 0)
                    {
                        node.next[index] = null;
                        return;
                    }
                node = node.next[index];
            }
            node.end--;
        }
    }
    //查当前树中有多少个字符串以传入的字符串为前缀
    public int preFixNumber(String word){
        if(word.isEmpty())
            return 0;
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char aChar : chars) {
            index = aChar - 'a';
            if(node.next[index] == null)
                return 0;
            node = node.next[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
        char s = 'l';
        System.out.println(Integer.valueOf(s));
    }
}
