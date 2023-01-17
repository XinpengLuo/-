package 主要练习.栈和队列.根据字符出现频率排序;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.time - n1.time;
            }
        });
        for (Character character : map.keySet()) {
            priorityQueue.add(new Node(character,map.get(character)));
        }
        StringBuilder res = new StringBuilder();
        while (priorityQueue.size() != 0){
            Node node = priorityQueue.poll();
            for(int i = 0; i < node.time; i++)
                res.append(node.c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}
class Node{
    char c;
    int time;
    public Node(char c, int time){
        this.c = c;
        this.time = time;
    }
}
