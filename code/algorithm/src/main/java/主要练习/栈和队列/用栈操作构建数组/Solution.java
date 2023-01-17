package 主要练习.栈和队列.用栈操作构建数组;

import 主要练习.树专题.公共节点.力扣.ListNode;

import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int start = 1;
        //1    --> 3
        //1 2
        for(int i = 0; i < target.length; i++){
            int num = target[i];
            while(start < num)
            {
                res.add("Push");
                start++;
            }
            for(int j = 0; j < num - (i > 0 ? target[i - 1] : 0) - 1; j++)
                res.add("Pop");
            res.add("Push");
            start++;
        }
        return res;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null, rightNode = null;
        ListNode temp = head;
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        newHead.next = head;
        int index = 1;
        while(temp != null){
            if(index == left)
                leftNode = temp;
            if(index == right)
                rightNode = temp;
            if(leftNode == null)
                pre = temp;
            index++;
            temp = temp.next;
        }
        ListNode next = rightNode.next;
        reverse(leftNode,rightNode.next);
        leftNode.next = next;
        pre.next = rightNode;
        return newHead.next;
    }
    public void reverse(ListNode head, ListNode end){
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        while(head != end){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
    }


    int count = 0;
    public int countTime(String time) {
        char a = time.charAt(0);
        char b = time.charAt(1);
        char c = time.charAt(3);
        char d = time.charAt(4);
        int left = 1 ,right = 1;
        if(a == '?' && b == '?')
            left = 24;
        if(a == '?' && b != '?'){
            if(b - '3' <= 0)
                left = 3;
            else
                left = 2;
        }
        if(a != '?' && b == '?'){
            if(a == '2')
                left = 4;
            else
                left = 10;
        }
        if(c == '?' && d == '?')
            right = 60;
        if(c != '?' || d != '?'){
            if(c == '?')
                right = 6;
            if(d == '?')
                right = 10;
        }
        return left * right;
    }



    public int[] productQueries(int n, int[][] queries) {
        List<Integer> power = new ArrayList<>();
        while(n > 0){
            int pow = (int) (Math.log(n) / Math.log(2));
            power.add(0, (int) Math.pow(2,pow));
            n -= Math.pow(2,pow);
        }
        int mod = (int) (Math.pow(10,9) + 7);
        long[] temp = new long[power.size()];
        temp[0] = power.get(0);
        for(int i = 1; i < temp.length; i++)
            temp[i] = temp[i - 1] * power.get(i);
        int[] res = new int[queries.length];
        int index = 0;
        System.out.println(power);
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            long sum = 1;
            for(int i = left; i <= right; i++)
                sum = ((sum % mod) * (power.get(i)) % mod) % mod;
            res[index] = (int) sum;
            index++;
        }
        return res;
    }


    public int minimizeArrayValue(int[] nums) {
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        long left = 0, right = Long.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(right,num);
        }
        if(left == right)
            return (int) left;
        long res = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long[] temp = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                temp[i] = nums[i];
            }
            for(int i = temp.length - 1; i >= 1; i--){
                if(temp[i] > mid)
                    temp[i - 1] += temp[i] - mid;
            }
            if(temp[0] <= mid) {
                right = mid - 1;
                res = mid;
            }
            else
                left = mid + 1;
        }
        return (int) res;
}


    public static void main(String[] args) {
        Solution solution = new Solution();
        //1 3 6 7
        //4 3 6 4
        //3 4 4 6
        //3 4 5 5
        //4 4 4 5
        int[] arr = {3,7,1,6};
        System.out.println(solution.minimizeArrayValue(arr));

    }
}