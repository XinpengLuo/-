package 左神.链表专题.k个一组反转单链表;

import 左神.树专题.公共节点.力扣.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1 || head.next == null)
            return head;
        ListNode temp = head;
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        newHead.next = head;
        while(temp != null){
            int count = k;
            ListNode cur = temp;
            while(count > 1 && temp.next != null){
                temp = temp.next;
                count--;
            }
            if(temp.next == null && count > 1)
            {
                
                pre.next = cur;
                break;
            }
            ListNode tail = temp;
            ListNode next = temp == null ? null : temp.next;
            reverseList(cur, k);
            pre.next = tail;
            pre = cur;
            temp = next;
        }
        return newHead.next;
    }
    public void reverseList(ListNode start, int size){
        ListNode head = new ListNode(-1);
        int k = 0;
        while(start != null && k != size){
            ListNode next = start.next;
            start.next = head.next;
            head.next = start;
            start = next;
            k++;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(3);
//        node1.next.next.next = new ListNode(4);
//        node1.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode listNode = solution.reverseKGroup(node1, 2);
        ListNode temp = listNode;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}