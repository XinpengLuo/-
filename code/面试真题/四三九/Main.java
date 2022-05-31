package 面试真题.四三九;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,6,3,2,1,9,3,1,5};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left == right)
            return;
        int middle = left + (right - left) / 2;
        mergeSort(arr,left,middle);
        mergeSort(arr,middle + 1,right);
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1;
        int index = 0;
        while(i <= middle || j <= right){
            int a = i > middle ? Integer.MIN_VALUE : arr[i];
            int b = j > right ? Integer.MIN_VALUE : arr[j];
            if(a > b){
                temp[index] = a;
                i++;
            }
            else{
                temp[index] = b;
                j++;
            }
            index++;
        }
        for(int k = left; k <= right; k++)
            arr[k] = temp[k - left];
    }
    public void example(){
        String[] words = new String[3];
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t1.length() - t2.length();
            }
        });
        PriorityQueue<String> test = null;
    }
}
