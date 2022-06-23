package 自己写的排序专题.每日练习;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void quickSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int i = left;
        int j = right;
        int target = arr[left];
        while(left < right){
            while(left < right && arr[right] >= target)
                right--;
            while(left < right && arr[left] <= target)
                left++;
            swap(arr,left,right);
        }
        swap(arr,i,left);
        quickSort(arr,i, left - 1);
        quickSort(arr,left + 1, j);
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = (right + left) / 2;
        mergeSort(arr,left, mid);
        mergeSort(arr,mid + 1,right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right){
            if(arr[i] >= arr[j])
                temp[index++] = arr[j++];
            else
                temp[index++] = arr[i++];
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= right)
            temp[index++] = arr[j++];
        index--;
        for(int k = right; k >= left; k--)
            arr[k] = temp[index--];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {3,2,1,6,3,12,34,6};
        String s = "2";
        ArrayList list = new ArrayList();

        main.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
