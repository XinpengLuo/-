package 主要练习.栈和队列.单调栈.下一个更大元素2;

import java.util.*;

public class Solution {
    //求数组中每个值右边最近的比他大的 左边最远比他的
    //维持两个单调栈
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i != nums.length * 2 - 1){
            if(stack.isEmpty() || nums[stack.peek()] >= nums[i % nums.length]){
                stack.push(i % nums.length);
                i++;
                continue;
            }
            int temp = stack.pop();
            res[temp] = nums[i % nums.length];
        }
        return res;
    }
}
