package 左神.位运算.十进制转n进制;

import java.util.*;

public class Solution {
    public static String convert(int number, int system) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.insert(0,number % system);
            number /= system;
        }
        return sb.toString();
    }
   //13 --> 1101
    public boolean isStrictlyPalindromic(int n) {
         for(int i = 2; i <= n - 2; i++){
             String convert = convert(n, i);
             System.out.println(convert);
             if(!check(convert))
                 return false;
         }
         return true;
    }
    public boolean check(String s){
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(convert(13,2));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            queue.offerLast(i);
            if(i >= k - 1){
                while(!queue.isEmpty() && queue.peekFirst() < i - k)
                    queue.pollFirst();
                ans[index] = nums[queue.peekFirst()];
                index++;
            }
        }
        return ans;
    }
}
