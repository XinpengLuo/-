package 临时测试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next().toString();
//        String[] arr  = str.split(",");
//        int[] b = new int[arr.length];
//        for(int j = 0; j<b.length;j++)
//            b[j] = Integer.parseInt(arr[j]);
       int[] arr = {10,2,3,5,6};
       quickSort(arr,0,arr.length -  1);
       ArrayList<Integer> list =  new ArrayList<>();

//        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right)
    {
       if(arr == null || arr.length == 0)
           return;
       if(left > right)
           return;
       int key = arr[left];
       int l = left;
       int r = right;
       while (l != r){
           while (arr[r] >= key && l < r)
               r--;
           while (arr[l] <= key && l < r)
               l++;
           if(l < r){
               int temp = arr[l];
               arr[l] = arr[r];
               arr[r] = temp;
           }

       }
       arr[left] = arr[l];
       arr[l] = key;
        System.out.println(Arrays.toString(arr));
       quickSort(arr,l + 1,right);
       quickSort(arr,left,l - 1);

    }
}
