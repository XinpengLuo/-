package 主要练习.栈和队列.单调栈.子数组的最小值之和;

import java.util.*;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int mod = (int) (Math.pow(10,9) + 7);
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int index = 0;
        while (index < arr.length){
            right[index] = -1;
            if(stack.isEmpty() || arr[stack.peek()] <= arr[index]){
                stack.push(index);
                index++;
                continue;
            }
            int i = stack.pop();
            right[i] = index;
        }
        stack.clear();
        index = arr.length - 1;
        while (index >= 0){
            left[index] = -1;
            if(stack.isEmpty() || arr[stack.peek()] < arr[index]){
                stack.push(index);
                index--;
                continue;
            }
            int i = stack.pop();
            left[i] = index;
        }
        for(int i = 0; i < arr.length; i++){
            int leftNum = left[i] == -1 ? i + 1 : i - left[i] ;
            int rightNum = right[i] == -1 ? arr.length - i : right[i] - i;
            res = ((long) leftNum * rightNum * arr[i] + res) % mod;
        }
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        Solution solution = new Solution();
        System.out.println(solution.sumSubarrayMins(arr));
    }
}
