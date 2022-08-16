package 面试真题.员工疲劳天数;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int countLarge = 0, countLess = 0;
        int j = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= 8)
                countLess++;
            else
                countLarge++;
            while(j <= i && countLess >= countLarge){
                if(arr[j] <= 8)
                    countLess--;
                else
                    countLarge--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }

}
