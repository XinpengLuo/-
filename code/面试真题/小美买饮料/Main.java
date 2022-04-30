package 面试真题.小美买饮料;

import java.util.Scanner;

public class Main {
    public static long getSum(int[] arr){
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
    public static String getAnswer(int[] arr,long target){
        long[] count = new long[arr.length];
        long temp = 0;
        for(int i = 0; i < count.length; i++){
            temp += arr[i];
            count[i] = temp;
        }
        for(int i = 0; i < arr.length; i++)
            for(int j = -1; j < i; j++){
                if((j == -1 && count[i] >= target) || count[i] - count[j + 1] >= target){
                    int left = j + 1;
                    int right = i;
                    if(left != 0 && right != arr.length - 1)
                        return "Yes";
                }
            }
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int length = scanner.nextInt();
            int[] arr = new int[length];
            for(int j = 0; j < arr.length; j++)
                arr[j] = scanner.nextInt();
            System.out.println(getAnswer(arr,getSum(arr)));
        }
    }
}
