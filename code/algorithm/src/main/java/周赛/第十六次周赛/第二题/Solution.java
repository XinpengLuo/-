package 周赛.第十六次周赛.第二题;

import 左神.树专题.公共节点.力扣.ListNode;

import java.util.Arrays;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] re : res) {
            Arrays.fill(re,-1);
        }
        int top = 0, bottom = m - 1, right = n - 1, left = 0;
        while (head != null){
            for(int i = left; i <= right && head != null; i++){
                res[top][i] = head.val;
                head = head.next;
            }
            for(int i = top + 1; i <= bottom && head != null; i++){
                res[i][right] = head.val;
                head = head.next;
            }
            for(int i = right - 1; i >= left && head != null; i--){
                res[bottom][i] = head.val;
                head = head.next;
            }
            for(int i = bottom - 1; i > top && head != null; i--){
                res[i][left] = head.val;
                head = head.next;
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        ListNode head = new ListNode(3);
        int[] arr = {0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode temp = head;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        Solution solution = new Solution();
        int[][] matrix = solution.spiralMatrix(m, n, head);
        System.out.println(Arrays.deepToString(matrix));
    }
}
