package 面试真题.b站挑数字;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i  < arr.length; i++)
            arr[i] = scanner.nextLong();
        String color = scanner.next();
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        for(int i = 0; i < color.length(); i++)
            if(color.charAt(i) == 'B')
                left.add(arr[i]);
            else
                right.add(arr[i]);
        Collections.sort(left);
        Collections.sort(right);
        long a = Math.max(
                left.get(left.size() - 1) * right.get(right.size() - 1),
                left.get(0) * right.get(0)
        );
        long b = Math.max(
                left.get(0) * right.get(right.size() - 1),
                left.get(left.size() - 1) * right.get(0)
        );
        System.out.println(Math.max(a,b));
    }
}
