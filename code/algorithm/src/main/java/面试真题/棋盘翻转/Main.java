package 面试真题.棋盘翻转;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] arr = new int[q][2];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        short[] num = new short[n];
        for(int i = 0; i < arr.length; i++){
            int left = arr[i][0];
            int right = arr[i][1];
            num[left - 1]++;
            num[right]--;
            count(num);
        }
    }
    public static void count(short[] num){
        int count = 0;
        int pre = 0;
        for(int i = 0; i < num.length; i++){
            int temp = num[i];
            if(i != 0)
                temp += pre;
            if (temp % 2 == 0)
                count++;
            pre = temp;
        }
        System.out.println(count);
    }
}