package 主要练习.链表专题.链表的孪生结点;

import 主要练习.树专题.公共节点.力扣.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        //i   n - 1 - i
        // n - 1 - i - i = n - 1 - 2 * i
        //1 --> 2 --> 3 --> 4 --> 5 --> 6
        if(head == null)
            return 0;
        if(head.next.next == null)
            return head.val + head.next.val;
        ListNode mid = findMid(head);
        ListNode right = reverse(mid);
        ListNode left = head;
        int res = 0;
        System.out.println(right.val);
        while(right != null){
            res = Math.max(res, left.val + right.val);

            left = left.next;
            right = right.next;
        }
        return res;
    }
    public ListNode findMid(ListNode head){
        ListNode first = head;
        ListNode second = head;
        while(first != null && first.next != null){
            first = first.next.next;
            second = second.next;
        }
        return second;
    }
    public ListNode reverse(ListNode head){
        ListNode newHead = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        int index = 3;



    }
}