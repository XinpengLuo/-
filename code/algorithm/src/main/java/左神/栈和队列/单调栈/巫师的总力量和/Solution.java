package 左神.栈和队列.单调栈.巫师的总力量和;

import java.util.*;

public class Solution {
    public int totalStrength(int[] strength) {
        int mod = (int) Math.pow(10,9) + 7;
        long res = 0;
        long[] sum = new long[strength.length];
        sum[0] = strength[0];
        for(int i = 1; i < strength.length; i++)
            sum[i] = sum[i - 1] + strength[i];
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[strength.length];
        int[] right = new int[strength.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        int index = 0;
        while (index < strength.length){
            if(stack.isEmpty() || strength[stack.peek()] <= strength[index]){
                stack.push(index);
                index++;
                continue;
            }
            int i = stack.pop();
            right[i] = index;
        }
        index = strength.length - 1;
        stack.clear();
        while (index >= 0){
            if(stack.isEmpty() || strength[stack.peek()] <= strength[index]){
                stack.push(index);
                index--;
                continue;
            }
            int i = stack.pop();
            left[i] = index;
        }
        for(int i = 0; i < strength.length; i++){
            long leftSum = left[i] == -1 ? 0 : sum[left[i]];
            long rightSum = right[i] == -1 ? sum[sum.length - 1] : sum[right[i] - 1];
            long temp = (rightSum - leftSum) * strength[i];
            res = ((res % mod) + (temp % mod)) % mod;
        }
        return (int) (res % mod);
    }
}
