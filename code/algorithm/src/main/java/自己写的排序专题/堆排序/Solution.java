package 自己写的排序专题.堆排序;

import java.net.Socket;
import java.util.Arrays;

public class Solution {
    public void insertHeap(int[] arr, int index){
        int parentIndex = (index - 1) / 2;
        while (arr[parentIndex] < arr[index]){
            swap(arr,index,parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapFy(int[] arr, int heapSize){
        int index = 0;
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize){
            int largerIndex = leftIndex + 1 < heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            largerIndex = arr[index] >= arr[largerIndex] ? index : largerIndex;
            if(largerIndex == index)
                return;
            swap(arr, largerIndex, index);
            index = largerIndex;
            leftIndex = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            insertHeap(arr,i);
        int heapSize = arr.length - 1;
        for(int i = 0; i < arr.length; i++){
            swap(arr,0,heapSize--);
            heapFy(arr,heapSize);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,7,2,1,-7,2,34,6};
        Solution solution = new Solution();
        solution.heapSort(arr);
    }
}
