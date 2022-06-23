package 左神.链表专题.链表中的下一个更大节点;

import 左神.树专题.公共节点.力扣.ListNode;

import java.awt.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        int length = getLength(head);
        int i = 0;
        while(i < length){
            if(stack.isEmpty() || stack.peek().val >= temp.val){
                stack.push(temp);
                temp = temp.next;
                i++;
                continue;
            }
            map.put(stack.pop(), temp.val);
        }
        int[] arr = new int[length];
        temp = head;
        for(int j = 0; j < length; j++){
            arr[j] = map.getOrDefault(temp,0);
            temp = temp.next;
        }
        return arr;
    }
    public int getLength(ListNode head){
        int length = 0;
        while(head != null)
            {
                length++;
                head = head.next;
            }
        return length;
    }
    public String greatestLetter(String s) {
        String res = "";
        int[] flagLower = new int[26];
        int[] flagUpper = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c))
                flagLower[c - 'a'] = 1;
            else
                flagUpper[c - 'A'] = 1;
        }
        for(int i = 0; i < 26; i++)
            if(flagLower[i] == 1 && flagUpper[i] == 1)
                res = String.valueOf((char)('A' + i));
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp == target)
                    return target;
                if(Math.abs(target - temp) < res){
                    res = Math.abs(target - temp);
                    ans = temp;
                }
                if(temp > target)
                    right--;
                else
                    left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

       int[] arr = {-4,-1,1,2};
       Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(arr, 1));

//        Solution solution = new Solution();
//        ListNode head = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        int[] ints = solution.nextLargerNodes(head);
//        System.out.println(Arrays.toString(ints));
    }
}
