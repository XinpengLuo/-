package 面试真题.法术;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] nums = new long[n];
        for(int i = 0; i < nums.length; i++)
            nums[i] = scanner.nextLong();
        long res = 0;
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++){
               if(nums[i] * nums[j] >= k)
                   res += 2;
            }
        System.out.println(res);
    }
}
