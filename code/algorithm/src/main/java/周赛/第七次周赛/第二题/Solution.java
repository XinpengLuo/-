package 周赛.第七次周赛.第二题;

import 左神.树专题.公共节点.力扣.ListNode;

import java.awt.*;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        ListNode next = temp.next.next;
        temp.next.next = null;
        temp.next = next;
        return head;
    }
}
