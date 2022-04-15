package 自己写的排序专题.归并排序;

import java.util.Arrays;

public class Solution {
    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid + 1,end);
        int[] tempArr = new int[end - start + 1];
        int i = start, j = mid + 1,index = 0;
        while (i <= mid && j <= end){
            if(arr[i] < arr[j])
                {
                    tempArr[index] = arr[i];
                    i++;
                }
            else {
                tempArr[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j <= end){
            tempArr[index] = arr[j];
            j++;
            index++;
        }
        while (i <= mid){
            tempArr[index] = arr[i];
            i++;
            index++;
        }
        for(int p = start,k = 0; p <= end; p++,k++)
            arr[p] = tempArr[k];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,6,1,4,2,1,10,9,8,7};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
