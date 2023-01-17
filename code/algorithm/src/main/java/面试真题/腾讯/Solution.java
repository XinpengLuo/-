package 面试真题.腾讯;

import 主要练习.树专题.公共节点.力扣.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    // 1 0 1 1 ^ 1 0 --> 1 0 0 1
    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        if(a == null || b == null)
            return a == null ? b : a;
        StringBuilder sbA = getNum(a);
        StringBuilder sbB = getNum(b).reverse();
        int diff = Math.abs(sbA.length() - sbB.length());
        if(sbA.length() < sbB.length()){
            for(int i = 0; i < diff; i++)
                sbA.insert(0,'0');
        }
        else{
            for(int i = 0; i < diff; i++)
                sbB.insert(0,'0');
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for(int i = 0; i < sbA.length(); i++){
            int val = 0;
            if(sbA.charAt(i) == sbB.charAt(i))
                val = 0;
            else
                val = 1;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
        }
        temp = head.next;
        while (temp.val == 0)
            temp = temp.next;
        return temp;
    }
    public StringBuilder getNum(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        return sb;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(0);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(1);

        ListNode node2 = new ListNode(0);
        node2.next = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.xorList(node1, node2));
    }
//     public ListNode reverse(ListNode head){
//         ListNode newHead = new ListNode(-1);
//         newHead.next = head;
//         ListNode temp = head;
//         while(temp != null){
//             ListNode next = head.next;
//             head.next = newHead.next;
//             newHead.next = head;
//             head = next;
//         }
//         return newHead.next;
//     }
}