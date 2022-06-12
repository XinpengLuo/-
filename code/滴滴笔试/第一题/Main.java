package 滴滴笔试.第一题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int length = scanner.nextInt();
            int[] arr = new int[length];
            for(int j = 0; j < arr.length; j++)
                arr[j] = scanner.nextInt();
            if(isValid(arr))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static boolean isValid(int[] arr){
        return dfs(arr,Integer.MIN_VALUE, Integer.MAX_VALUE,0);
    }
    public static boolean dfs(int[] arr, int onValue, int offValue, int index){
        if(index >= arr.length)
            return true;
        boolean flag = false;
        if(arr[index] <= onValue && arr[index] >= offValue)
            return false;
        if(arr[index] > onValue)
            flag = flag || dfs(arr,arr[index],offValue, index + 1);
        if(arr[index] < offValue)
            flag = flag || dfs(arr,onValue,arr[index],index + 1);
        return flag;
    }
}
