package 主要练习.贪心算法.项目利润;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node t1, Node t2) {
                return t1.c - t2.c;
            }
        });
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node t1, Node t2) {
                return t2.p - t1.p;
            }
        });
        for (int i = 0; i < Capital.length; i++) {
            minCostQ.add(new Node(Capital[i],Profits[i]));
        }
        while (k > 0){
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W)
                maxProfitQ.add(minCostQ.poll());
            if(maxProfitQ.isEmpty())
                return W;
            W += maxProfitQ.poll().p;
            k--;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] p = {1,2,3};
        int[] c = {0,0,0};
        findMaximizedCapital(1,10,p,c);
    }
}
class Node{
    int c;
    int p;
    public Node(int c,int p){
        this.c = c;
        this.p = p;
    }
}