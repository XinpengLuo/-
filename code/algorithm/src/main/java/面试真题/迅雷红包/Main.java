package 面试真题.迅雷红包;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for(int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(s[i]);
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            preSum[i] = nums[i] + preSum[i - 1];
        int res = 0;
        for(int i = 1; i < nums.length - 1; i++)
            for(int j = i; j < nums.length - 1; j++){
                int left = preSum[i] - nums[i];
                int middle = preSum[j] - left;
                int right = preSum[preSum.length - 1] - left - middle;
                if(left <= middle && middle <= right)
                    res++;
            }
        System.out.println(res);
    }
}
