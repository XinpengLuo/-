package 左神.链表专题;

import 左神.树专题.公共节点.力扣.ListNode;
import 左神.树专题.公共节点.力扣.TreeNode;
import 生成器.GenerateClass;

import java.awt.*;
import java.awt.List;
import java.util.*;

import static 生成器.GenerateClass.generateList;
import static 生成器.GenerateClass.generateTree;

public class NodeTest {

    //找出链表的中间节点
    public static Node midNode(Node head)
    {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //跟据链表的头节点 以及传入的值 让小于值的节点全部放在左边 等于的在中间 大于的在右边
    public static Node sortNodeByVal(Node head, int num)
    {
        Node sHead = null, sTail = null, eHead = null, eTail = null, bHead = null, bTail = null, next = null;
        while (head != null)
        {
            next = head.next;
            head.next = null;
            if(head.val < num)
            {
                if(sHead == null){
                    sHead = head;
                    sTail = head;
                }else {
                    sTail.next = head;
                    sTail = sTail.next;
                }
            }
            if(head.val == num)
            {
                if(eHead == null){
                    eHead = head;
                    eTail = head;
                }else{
                    eTail.next = head;
                    eTail = eTail.next;
                }
            }
            if(head.val > num){
                if(bHead == null){
                    bHead = head;
                    bTail = head;
                }else{
                    bTail.next = head;
                    bTail = eTail.next;
                }
            }
            head = next;
        }
        if(sTail != null)
        {
            sTail.next = eHead;
            eTail = eTail == null ? sTail : eTail;
        }
        if(eTail != null)
            eTail.next = bHead;
        return sHead != null ? sHead : (eHead != null ? eHead : bHead);
    }
    //克隆复杂链表 用哈希表
    public Node copyRandomListByHash(Node head) {
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node temp = head;
        while (temp != null)
        {
            nodeNodeHashMap.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null)
        {
            nodeNodeHashMap.get(temp).next = nodeNodeHashMap.get(temp.next);
            nodeNodeHashMap.get(temp).random = nodeNodeHashMap.get(temp.random);
            temp = temp.next;
        }
        return nodeNodeHashMap.get(head);
    }
    public Node copyRandomList(Node head){
        if(head == null) //这个十分关键 这样设计后后面再构造最少都有两个节点 就不会为null了
            return head;
        Node temp = head;
        Node next = null;
        while (temp != null){
            next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }
        temp = head;
        while (temp != null)
        {
            next = temp.next.next;
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = next;
        }
        Node res = head.next;
        temp = head;
        Node curCopy = null;
        //再把两个链表分离
        while (temp != null){
            next = temp.next.next;
            curCopy = temp.next;
            temp.next = next;

            curCopy.next = next != null ? next.next : null;
            temp = next;
        }
        return res;
    }
    //判断环形链表
    public boolean hasCycle(Node head) {
        boolean flag = false;
        HashSet<Node> nodes = new HashSet<>();
        Node temp = head;
        while (temp != null){
            if(nodes.contains(temp)){
                flag = true;
                break;
            }
            nodes.add(temp);
            temp = temp.next;
        }
        return flag;
    }
    //返回入环的第一个节点
    public Node detectCycleByHash(Node head) {
        Node result = null;

        HashSet<Node> nodes = new HashSet<>();
        Node temp = head;
        while (temp != null){
            if(nodes.contains(temp)){
                result = temp;
                break;
            }
            nodes.add(temp);
            temp = temp.next;
        }
        return result;
    }
    //快慢指针的方法 返回第一个入环节点
    public ListNode detectCycyle(ListNode head)
    {
        if(head == null || head.next == null || head.next.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast)
        {
            if(fast.next == null || fast.next.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回两个相交链表的第一个节点 第一种方法用hash这里用差值法 （这种最简单不带环）
    public ListNode getIntersectionNodeNoLoop(ListNode headA, ListNode headB)
    {
        if(headA == null || headB == null)
            return null;
        int n = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2)
            return null;
        cur1 = n > 0 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public ListNode getIntersectionNodeLoop(ListNode headA, ListNode loop1, ListNode headB, ListNode loop2){
        ListNode cur1 = null;
        ListNode cur2 = null;
        if(loop1 == loop2){
            cur1 = headA;
            cur2 = headB;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? headA : headB;
            cur2 = cur1 == headA ? headB : headA;
            n = Math.abs(n);
            //这里不用判断尾节点是否相同 因为最外层很明显已经有了判断 入环节点相同 代表肯定相交
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else {
            cur1 = loop1.next;
            while (loop1 != cur1){
                if(cur1 == loop2)
                    return loop1;
                loop1 = loop1.next;
            }
        }
        return null;
    }
    //接下来需要判断两个不一定带环链表的链表的第一个相交节点
    public ListNode getIntersectNode(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null)
            return null;
        ListNode loop1 = detectCycyle(head1);
        ListNode loop2 = detectCycyle(head2);
        if(loop1 == null && loop2 == null)
            return getIntersectionNodeNoLoop(head1, head2);
        if(loop1 != null && loop2 != null)
            return getIntersectionNodeLoop(head1,loop1,head2,loop2);
        return null;
    }
    //判断是否是回文链表
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode next;
        while (slow != null){
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        while (pre != null){
            if(head.val != pre.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
    //排序链表 插入排序
    public ListNode SortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = head;
        head.next = null;
        ListNode next;
        while (temp != null){
            next = temp.next;
            ListNode cur = newHead;
            if(temp.val > cur.val) {
                ListNode pre = newHead;
                while (cur != null && cur.val < temp.val) {
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = temp;
            }
            else
                newHead = temp;
            temp.next = cur;
            temp = next;
        }
        return newHead;
    }
    //删除排序链表中的重复元素
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = null;
        ListNode cur = newHead;
        while (head != null){
           temp = head.next;
           if(temp == null || temp.val != head.val)
               {
                   cur.next = head;
                   cur = cur.next;
               }
           else{
               while (temp != null && temp.val == head.val)
                   temp = temp.next;
           }
           head = temp;
        }
        cur.next = null;
        return newHead.next;
    }
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null)
            {
                stack1.push(l1);
                l1 = l1.next;
            }
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int preVal = 0;
        int newVal = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || preVal != 0){
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;
            newVal = a + b + preVal;
            if(newVal > 9){
                newVal = newVal - 10;
                preVal = 1;
            }
            else
                preVal = 0;
            cur = new ListNode(newVal);
            cur.next = head.next;
            head.next = cur;
        }

        return head.next;
    }
    //返回链表的倒数第k个节点
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (k-- > 0){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        return second.val;
    }
    //二叉树中的列表
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null && head != null)
            return false;
        if(!isSubPathPro(head,root))
            return isSubPath(head,root.left) || isSubPath(head,root.right);
        return true;
    }
    public boolean isSubPathPro(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        if(root == null && head != null)
            return false;
        if(head.val != root.val)
            return false;
        if(!isSubPathPro(head.next,root.left) && !isSubPathPro(head.next,root.right))
            return false;
        return true;
    }
    //二进制链表转整数
    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        int value = 0;
        while (head != null)
        {
            value = value << 1;
            value = value + head.val;
        }
        return value;
    }
    //反转部分链表
    public  static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = newHead;
        ListNode left = null;
        ListNode right = null;
        int index = 0;
        while (index <= n){
            if(index == m - 1)
                left = temp;
            if(index >= m && index <= n){
                stack.push(temp);
            }
            index++;
            temp = temp.next;
        }
        right = temp;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            left.next = pop;
            left = left.next;
            if(stack.isEmpty())
                pop.next = right;
        }
        return newHead.next;
    }
    //分隔链表
    public ListNode partition(ListNode head, int x) {
        ListNode headA = new ListNode(0) , tempA = headA; //存放小于的
        ListNode headB = new ListNode(0) , tempB = headB; //存放大于的
        while (head != null){
            if(head.val < x){
                tempA.next = head;
                tempA = tempA.next;
            }else{
                tempB.next = head;
                tempB = tempB.next;
            }
            head = head.next;
        }
        tempA.next = headB.next;
        tempB.next = null;
        return headA.next;
    }
    public static void main(String[] args) {

       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);
       node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseBetween(node1, 2, 4));
    }


}
class Node{
    int val;
    Node next;
    Node random;
    public Node(int val)
    {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
//class ListNode {
//     int val;
//      ListNode next;
//      ListNode(int x) {
//     val = x;
//          next = null;
//      }
//    @Override
//    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
//  }
