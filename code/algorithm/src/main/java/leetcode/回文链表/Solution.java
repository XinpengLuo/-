package leetcode.回文链表;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (!stack.empty()){
            if(temp.val != stack.pop().val)
                return false;
            temp = temp.next;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
