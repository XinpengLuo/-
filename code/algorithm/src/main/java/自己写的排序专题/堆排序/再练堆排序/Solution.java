package 自己写的排序专题.堆排序.再练堆排序;

import java.net.Socket;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public void insertHeap(int[] arr, int index){
        int parentIndex = (index - 1) / 2;
        while (arr[parentIndex] < arr[index]){
            swap(arr,index,parentIndex);
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
            if(index == largerIndex)
                return;
            swap(arr,index,largerIndex);
            index = largerIndex;
            leftIndex = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insertHeap(arr,i);
        }
        int heapSize = arr.length - 1;
        for(int i = 0; i < arr.length; i++){
            swap(arr,0,heapSize--);
            heapFy(arr,heapSize);
        }
    }
    public void swap(int[] arr, int i, int j){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,1,5,6,0,2,1,4,5};
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
