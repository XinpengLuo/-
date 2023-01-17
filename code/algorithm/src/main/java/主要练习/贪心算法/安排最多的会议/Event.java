package 主要练习.贪心算法.安排最多的会议;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Event {
    public int maxEvents(int[][] events) {
        PriorityQueue<Node> minEndDay = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.endDay - n2.endDay;
            }
        });
        for (int i = 0; i < events.length; i++) {
            minEndDay.add(new Node(events[i][0],events[i][1]));
        }
        int result = 1;
        int cur = minEndDay.poll().endDay;
        while (!minEndDay.isEmpty()){
            Node temp = minEndDay.poll();
            if(temp.endDay >= cur){
                result++;
                cur = temp.endDay;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
class Node{
    int startDay;
    int endDay;
    public Node(int startDay, int endDay){
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
