package 面试真题.小美的仓库;


import java.util.Scanner;

public class Main {
    public static int getAnswerSlideWindow(int temp, int[] arr){
        long sum = temp;
        int res = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            while (j < i && sum < 0){
                sum -= arr[j];
                j++;
            }
            if(sum >= 0){
                res = Math.max(res,i - j + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int temp = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = in.nextInt();
        System.out.println(getAnswerSlideWindow(temp,arr));
    }
}
