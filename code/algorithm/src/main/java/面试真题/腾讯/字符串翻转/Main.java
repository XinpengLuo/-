package 面试真题.腾讯.字符串翻转;

import java.util.*;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        sb.append('0');
        while (sb.length() < r){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < sb.length(); i++)
                if(sb.charAt(i) == '0')
                    temp.append('1');
                else
                    temp.append('0');
            sb.append(temp.toString());
            System.out.println(sb.toString());
        }
        int count = 0;
        for(int i = l - 1; i <= r - 1; i++)
            if(sb.charAt(i) == '1')
                count++;
        System.out.println(count);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    }
}
