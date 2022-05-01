package 面试真题.晋级赛;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static  int getAnswer(int[] arr, int x, int y){
        int left = 0;
        int right = arr.length;
        int res = -1;
        while (left <= right){
            int middle = left + (right - left) / 2; //表示下标
            int less = middle + 1;
            int large = arr.length - less;
            if(less >= x && less <= y && large >= x && large <= y)
            {
                res = middle;
                right = middle - 1;
            }
            if(less > y || large < x)
                right = middle - 1;
            else if(less < x || large > y)
                left = middle + 1;
        }
        return arr[res];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);
        System.out.println(getAnswer(arr, x, y));
    }
}
