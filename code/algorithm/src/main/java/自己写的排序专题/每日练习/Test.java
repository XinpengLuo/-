package 自己写的排序专题.每日练习;

import java.util.*;

public class Test {
    public void quickSort(int left, int right, int[] arr){
        if(left >= right)
            return;
        int i = left;
        int j = right;
        int target = arr[left];
        while (i < j){
            while (i < j && arr[j] >= target)
                j--;
            while (i < j && arr[i] <= target)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSort(left,i - 1,arr);
        quickSort(i + 1,right,arr);
    }

    public void mergeSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int mid = i + (j - i) / 2;
        mergeSort(arr,i,mid);
        mergeSort(arr,mid + 1,j);
        int[] temp = new int[j - i + 1];
        int l = i, r = mid + 1, index = 0;
        while (l <= mid || r <= j){
            int a = l <= mid ? arr[l] : Integer.MAX_VALUE;
            int b = r <= j ? arr[j] : Integer.MAX_VALUE;
            if(a <= b){
                temp[index] = a;
                l++;
            }
            else {
                temp[index] = b;
                r++;
            }
            index++;
        }
        for(int k = i; k <= j; k++)
            arr[k] = temp[k - i];
    }



    public static void main(String[] args) {
        int[] arr = {3,5,23,12,56};
        Test test = new Test();
        test.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
