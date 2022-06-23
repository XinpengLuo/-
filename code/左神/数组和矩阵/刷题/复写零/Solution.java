package 左神.数组和矩阵.刷题.复写零;

import java.net.Socket;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public void duplicateZeros(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        while(stack.size() != arr.length){
            stack.push(arr[j]);
            if(stack.size() >= arr.length)
                break;
            if(arr[j] == 0)
                stack.push(arr[j]);
            if(stack.size() >= arr.length)
                break;
            j++;
        }
        for(int i = arr.length - 1; i >= 0; i--)
            arr[i] = stack.pop();
    }
    public void better(int[] arr){
        int n = arr.length;
        int count = 0;
        int last = 0;
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0)
                count++;
            else{
                if(count + 2 <= n)
                    count += 2;
                else
                {
                    count++;
                    flag = true;
                }
            }
            if(count == n)
                {last = i;
                break;}
        }
        int index = n - 1;
        for(int i = last; i >= 0; i--){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index--;
            }
            else{
                if(flag){
                    arr[index] = 0;
                    index--;
                    flag = false;
                    continue;
                }
                arr[index] = 0;
                arr[index - 1] = 0;
                index -= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,0,0,0,0,7};
        Solution solution = new Solution();
        solution.better(arr);
        System.out.println(Arrays.toString(arr));
    }
}
