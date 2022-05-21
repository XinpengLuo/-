package 面试真题.网易电影院选座;


import java.util.Scanner;

public class Main {
    public static int getAnswer(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int temp = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 1)
                temp = i;
            left[i] = temp;
        }
        temp = -1;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (arr[i] == 1)
                temp = i;
            right[i] = temp;
        }
        int distance = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                continue;
            if(left[i] != -1 && right[i] != -1)
                distance = Math.max(distance,Math.min(i - left[i], right[i] - i));
            else
                distance = Math.max(distance,left[i] == -1 ? right[i] - i : i - left[i]);
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(getAnswer(arr));
    }
}
