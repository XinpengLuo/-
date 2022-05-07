package 左神.字符串.前K个高频单词;
import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node t1, Node t2) {
                if(t1.count == t2.count)
                    return t1.word.compareTo(t2.word);
                return t2.count - t1.count;
            }
        });
        for (String s : map.keySet()) {
            queue.add(new Node(s,map.get(s)));
        }
        List<String> res = new ArrayList<>();
        while (k-- > 0){
            res.add(queue.poll().word);
        }
        return res;
    }
}
class Node{
    String word;
    int count;
    public Node(String word, int count){
        this.word = word;
        this.count = count;
    }
}
