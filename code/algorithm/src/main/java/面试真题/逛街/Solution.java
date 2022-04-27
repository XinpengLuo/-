package 面试真题.逛街;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static int[] getAnswer(int[] arr){
        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            leftArr[i] = left.size() + 1;
            int j = arr.length - 1 - i;
            rightArr[j] = right.size();
            while(!left.isEmpty() && arr[left.peek()] < arr[i])
                left.pop();
            while(!right.isEmpty() && arr[right.peek()] < arr[j])
                right.pop();
            left.push(i);
            right.push(j);
            ans[i] += leftArr[i];
            ans[j] += rightArr[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int[] answer = getAnswer(arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
}
