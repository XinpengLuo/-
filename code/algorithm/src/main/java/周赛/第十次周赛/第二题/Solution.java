package 周赛.第十次周赛.第二题;

import 左神.树专题.公共节点.力扣.ListNode;

import java.awt.*;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        int tempSum = 0;
        boolean flag = false;
        while (head != null){
            if(head.val == 0){
                if(tempSum != 0)
                    {
                        temp.next = new ListNode(tempSum);
                        temp = temp.next;
                        tempSum = 0;
                    }
            }
            else
                tempSum += head.val;
            head = head.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(0);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(0);
        ListNode node = solution.mergeNodes(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
