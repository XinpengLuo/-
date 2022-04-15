package 左神.栈和队列.单调栈.下一个更大元素1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        // 问题转换为求每一个元素的 离它最近的下一个更大值 因为num1的顺序和num2出现的顺序不一样要哈希表
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i != nums2.length){
            if(stack.isEmpty() || nums2[stack.peek()] > nums2[i]){
                stack.push(i);
                i = i + 1;
                continue;
            }
            int temp = stack.pop();
            hashMap.put(nums2[temp],nums2[i]);
        }
        int f = 0;
        while (!stack.isEmpty())
            hashMap.put(nums2[stack.pop()],-1);
        for (int j = 0; j < nums1.length; j++) {
            res[j] = hashMap.get(nums1[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        Solution solution = new Solution();
        solution.nextGreaterElement(nums1,nums2);
    }
}
