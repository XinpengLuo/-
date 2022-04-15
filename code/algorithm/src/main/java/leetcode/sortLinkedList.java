package leetcode;

import java.awt.*;

public class sortLinkedList {
    public static ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head;
        int i = 0;
        while(temp != null)
        {
            i++;
            temp = temp.next;
        }
        ListNode[] nodeArray = new ListNode[i];
        i = 0;
        temp = head;
        while(temp != null)
        {
            nodeArray[i] = temp;
            i++;
            temp = temp.next;
        }
        ListNode cur = null;
        for(i = 0; i < nodeArray.length - 1; i++)
            for(int j = 0; j < nodeArray.length - i - 1; j++)
            {
                if(nodeArray[j + 1].val < nodeArray[j].val)
                {
                    temp = nodeArray[j + 1];
                    nodeArray[j + 1] = nodeArray[j];
                    nodeArray[j] = temp;
                }
            }
        for(i = 0; i < nodeArray.length - 1; i++)
        {
            nodeArray[i].next = nodeArray[i + 1];
        }
        nodeArray[i].next = null;
        return nodeArray[0];
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(22);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode test = null;
        ListNode listNode = sortList(test);
//        System.out.println(listNode.toString());
    }
}


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
