package 自己写的排序专题.堆排序;

import java.net.Socket;
import java.util.Arrays;

public class Solution {
    public void insertHeap(int[] arr, int index){
        int parentIndex = (index - 1) / 2;
        while (arr[parentIndex] < arr[index]){
            swap(arr,parentIndex,index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    public void heapFy(int[] arr, int heapSize){
        int index = 0;
        int leftIndex = index * 2 + 1;
        while (leftIndex <= heapSize){
            int largerIndex = leftIndex + 1 <= heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            largerIndex = arr[index] >= arr[largerIndex] ? index : largerIndex;
            if(largerIndex == index)
                return;
            swap(arr,index,largerIndex);
            index = largerIndex;
            leftIndex = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            insertHeap(arr,i);
        int size = arr.length - 1;
        for(int i = 0; i < arr.length; i++){
            swap(arr,0,size);
            heapFy(arr,--size);
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,1,3,5,7,231,2};
        Solution solution = new Solution();
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
