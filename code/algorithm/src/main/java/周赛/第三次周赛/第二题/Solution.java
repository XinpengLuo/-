package 周赛.第三次周赛.第二题;

import 主要练习.树专题.公共节点.力扣.ListNode;

public class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int count = 1;
        ListNode temp = head;
        ListNode preNode = new ListNode(-1);
        ListNode ans = preNode;
        while (temp != null){

            int tempCount = 1;
            ListNode tempHead = temp;
            ListNode tempTail = temp;

            while (tempTail != null && tempCount != count && tempTail.next != null){
                tempTail = tempTail.next;
                tempCount++;
            }
            ListNode next = tempTail == null ? null : tempTail.next;
            if( tempCount % 2 == 0)
            {
                preNode.next = reverse(tempHead,tempTail.next);
                preNode = tempHead;
            }
            else
            {
                preNode.next = tempHead;
                preNode = tempTail;
            }
            count++;
            temp = next;
        }
        return ans.next;
    }
    public ListNode reverse(ListNode head, ListNode tail){
        if(head == null || head.next == null)
            return head;
         ListNode temp = head;
         ListNode newHead = new ListNode(-1);
         while (temp != tail){
             ListNode next = temp.next;
             temp.next = newHead.next;
             newHead.next = temp;
             temp = next;
         }
         return newHead.next;
    }
//    public ListNode better(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//
//    }
    public static void main(String[] args) {
//        int[] arr = {5,2,6,3,9,1,7,3,8,4};
        int[] arr = {0,4,2,1,3};
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        temp = head.next;
        while (temp != null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("---------");
        temp = head.next;
        Solution solution = new Solution();
        solution.reverseEvenLengthGroups(temp);
        temp = head.next;
        while (temp != null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
