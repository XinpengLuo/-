package 面试真题.阿里子集;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int getAnswer(int[][] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0] == t2[0])
                    return t2[1] - t1[1];
                return t1[0] - t2[0];
            }
        });
        int[] dp = new int[arr.length + 1];
        dp[1] = arr[0][1];
        int len = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i][1] > dp[len])
                dp[++len] = arr[i][1];
            else{
                int left = 0;
                int right = len;
                int res = -1;
                while (left <= right){
                    int middle = left + (right - left) / 2;
                    if(dp[middle] >= arr[i][1]){
                        res = middle;
                        right = middle - 1;
                    }else
                        left = middle + 1;
                }
                dp[res] = arr[i][1];
            }
        }
        return len;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int count = scanner.nextInt();
            int[][] arr = new int[count][2];
            for(int j = 0; j < arr.length; j++)
                arr[j][0] = scanner.nextInt();
            for(int j = 0; j < arr.length; j++)
                arr[j][1] = scanner.nextInt();
            System.out.println(getAnswer(arr));
        }
    }
}
