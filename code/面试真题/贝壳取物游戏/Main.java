package 面试真题.贝壳取物游戏;

import java.util.Scanner;

public class Main {
    public static int dfs(int[] arr, int time, int k, int m){
        if(time <= 0)
            return 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                int temp = arr[i];
                int res = 0;
                arr[i] = -1;
                if(temp > m)
                    res = dfs(arr,time - k - 1,k,m);
                else
                    res = dfs(arr,time - 1,k,m);
                ans = Math.max(res + temp, ans);
                arr[i] = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[time];
        for(int i = 0; i < time; i++)
            arr[i] = scanner.nextInt();
        System.out.println(dfs(arr, time, k, m));
    }
}
