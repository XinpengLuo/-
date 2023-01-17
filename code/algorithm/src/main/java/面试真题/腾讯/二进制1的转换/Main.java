package 面试真题.腾讯.二进制1的转换;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Math.abs(t2 - Integer.bitCount(t2)) - Math.abs(t1 - Integer.bitCount(t1));
            }
        });
        for(int i = 0; i < n; i++)
            queue.add(scanner.nextInt());
        while (k-- > 0){
            Integer num = queue.poll();
            queue.add(Integer.bitCount(num));
        }
        int sum = 0;
        while (!queue.isEmpty())
            sum += queue.poll();
        System.out.println(sum);
    }
}
