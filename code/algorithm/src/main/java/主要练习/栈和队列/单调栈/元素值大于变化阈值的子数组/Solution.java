package 主要练习.栈和队列.单调栈.元素值大于变化阈值的子数组;

import java.util.*;

public class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        //由栈底 --》 栈顶 从小到大
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(right,nums.length);
        Arrays.fill(left,-1);
        for(int i = 0; i < nums.length;){
            if(stack.isEmpty() || nums[stack.peek()] <= nums[i]){
                stack.push(i);
                i++;
                continue;
            }
            int temp = stack.pop();
            right[temp] = i;
        }
        stack.clear();
        for(int i = nums.length - 1; i >= 0;){
            if(stack.isEmpty() || nums[stack.peek()] <= nums[i]){
                stack.push(i);
                i--;
                continue;
            }
            int temp = stack.pop();
            left[temp] = i;
        }
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            count += (right[i] - i);
            count += (left[i] == -1 ? i : i - left[i] - 1);
            if(nums[i] > (threshold / count))
                return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,3,1};
        Solution solution = new Solution();
        System.out.println(solution.validSubarraySize(arr, 6));
    }
}
