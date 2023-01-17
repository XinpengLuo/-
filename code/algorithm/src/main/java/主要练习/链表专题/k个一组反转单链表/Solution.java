package 主要练习.链表专题.k个一组反转单链表;

import 主要练习.树专题.公共节点.力扣.ListNode;

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
class Main{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode temp = newHead;
        while (temp != null){
            ListNode cur = temp;
            for(int i = 0; i < k; i++){
                temp = temp.next;
                if(temp == null)
                    return newHead.next;
            }
            ListNode next = temp.next;
            temp.next = null;
            ListNode tail = cur.next;
            cur.next = reverseNode(cur.next);
            tail.next = next;
            temp = next;
        }
        return newHead.next;
    }
    public ListNode reverseNode(ListNode head){
        ListNode newHead = new ListNode(-1);
        ListNode temp = head;
        while (temp != null){
            ListNode next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        Main main = new Main();
        ListNode temp = main.reverseKGroup(head,1);
        while (temp != null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}