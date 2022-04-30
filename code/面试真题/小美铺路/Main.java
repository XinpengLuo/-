package 面试真题.小美铺路;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int getAnswer(int n, int[] arr , int m){
        int index = 0;
        int pre = 0;
        int j = 0;
        int count = 0;
        while (index <= n){
            if(j < arr.length)
                index = arr[j];
            if(pre <= index)
                count += ((index - pre) / m +( (index - pre) % m == 0 ? 0 : 1));
            index += m;
            pre = index;
            if(j < arr.length - 1)
                j++;
            else{
                count += ((n - index) / m + ((n - index) % m == 0 ? 0 : 1));
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[x];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        System.out.println(getAnswer(n, arr, m));
    }
}
