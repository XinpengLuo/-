package 面试真题.字节抓捕孔连顺;

import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

import java.util.Scanner;

public class Main {
    public static long getAnswer(int[] arr, int max){
        long res = 0;
        for(int i = 0; i < arr.length; i++){
            //求右边最后一个小于等于arr[i] + max
            int right = binarySearchRight(arr,i + 1,arr.length - 1,arr[i] + max);
            if(right != -1 && right - i >= 2){
                long num = right - i;
                res += (num * (num  - 1) / 2);
            }
        }
        return res % 99997867;
    }
    public static int binarySearchRight(int[] arr, int i, int j, int target){
        int res = -1;
        while (i <= j){
            int middle = i + (j - i) / 2;
            if(arr[middle] <= target){
                res = middle;
                i = middle + 1;
            }
            else
                j = middle - 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxLength = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        System.out.println(getAnswer(arr, maxLength));
    }
}
