package 主要练习.链表专题.从链表中删去总和值为零的连续节点;

import 主要练习.树专题.公共节点.力扣.ListNode;

import java.util.HashMap;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return null;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        map.put(0,newHead);
        ListNode temp = head;
        while (temp != null){
            sum += temp.val;
            if(map.containsKey(sum)){
                ListNode pre = map.get(sum);
                ListNode cur = pre.next;
                int tempSum = sum;
                while (cur != temp){
                    tempSum += cur.val;
                    map.remove(tempSum);
                    cur = cur.next;
                }
                pre.next = temp.next;
            }
            else
                map.put(sum,temp);
            temp = temp.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        Solution solution = new Solution();
        ListNode node = solution.removeZeroSumSublists(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
