package 面试真题.小米反转链表;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> newHead = new ListNode<>();
        newHead.data = -1;
        ListNode<Integer> start = null;
        ListNode<Integer> end = null;
        ListNode<Integer> temp = newHead;
        ListNode<Integer> pre = null;
        newHead.next = head;
        while(temp != null && temp.data != left)
        {
            pre = temp;
            temp = temp.next;
        }
        start = temp;
        ListNode<Integer> newTail = temp;
        while(temp != null && temp.data != right)
            temp = temp.next;
        end = temp.next;
        pre.next = null;
        while(start != end){
            ListNode<Integer> next = start.next;
            start.next = pre.next;
            pre.next = start;
            start = next;
        }
        newTail.next = end;
        return newHead.next;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}
