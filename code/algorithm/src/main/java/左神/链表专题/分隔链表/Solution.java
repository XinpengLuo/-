package 左神.链表专题.分隔链表;

import 左神.树专题.公共节点.力扣.ListNode;

import java.awt.*;
import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null)
            stack.push(temp);
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop().val)
                return false;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(node));
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if(root == null)
            return res;
        //获得链表的长度
        int count = 0;
        ListNode temp = root;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        int num = count / k;
        int mod = count % k;
        int time = mod;
        temp = root;
        int index = 0;
        while (temp != null){
            res[index] = temp;
            int length = num;
            if(time-- != 0)
                length = num + 1;
            for(int i = 0; i < length; i++){
                if(temp == null)
                    break;
                temp = temp.next;
            }
            if(temp == null)
                break;
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
            index++;
        }
        return res;
    }
}
