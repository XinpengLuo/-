package 主要练习.链表专题.删除链表的倒数第N个结点;

import 主要练习.树专题.公共节点.力扣.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(-1);
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            if(n-- == 1)
                continue;
            ListNode next = newHead.next;
            newHead.next = node;
            newHead.next.next = next;
        }
        return newHead.next;
    }

    public ListNode better(ListNode head, int n){
        if(head == null)
            return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode first = head;
        for(int i = 0; i < n; i++)
            first = first.next;
        while (first != null){
            slow = slow.next;
            first = first.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
        Solution solution = new Solution();
//        node1.next = node2;
//        node2.next = node3;
        solution.better(node1,1);
    }
}
