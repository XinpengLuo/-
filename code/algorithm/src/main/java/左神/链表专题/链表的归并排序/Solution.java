package 左神.链表专题.链表的归并排序;

import 左神.树专题.公共节点.力扣.ListNode;

import java.awt.*;

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //找到链表的中点
        ListNode first = head, second = head;
        ListNode pre = null;
        while (second != null && second.next != null){
            pre = first;
            first = first.next;
            second = second.next.next;
        }
        //此时first是中点
        ListNode next = pre.next;
        pre.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(next);
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while (l != null && r != null){
            if(l.val < r.val){
                temp.next = l;
                l = l.next;
            }
            else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        temp.next = l == null ? r : l;
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        solution.sortList(listNode1);
    }
}
