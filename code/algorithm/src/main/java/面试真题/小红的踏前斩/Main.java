package 面试真题.小红的踏前斩;

import java.util.*;

//5
//2 3 4 2 3

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(i + 2 < arr.length){
                while (arr[i] >= 1 && arr[i + 1] >= 2 && arr[i + 2] >= 3){
                    arr[i] -= 1;
                    arr[i + 1] -= 2;
                    arr[i + 2] -= 3;
                    count += 5;
                }
            }else{
                count += arr[i];
                arr[i] = 0;
            }
            if(arr[i] != 0)
                count += arr[i];
        }
        System.out.println(count);
    }
}
