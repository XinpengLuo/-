package 左神.数组和矩阵.有序矩阵中第K个最小数组和;

public class Solution {
    public void heapInsert(int[] arr, int index){
        while (arr[index] < arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public void heapFy(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while (left < size){
            int min = left + 1 < size && arr[left + 1] < arr[left] ? left + 1 : left;
            min = Math.min(arr[min],arr[index]);
            if(min == index)
                break;
            swap(arr,index,min);
            index = min;
            left = index * 2 + 1;
        }
    }
    public int kthSmallest(int[][] mat, int k) {
        return 0;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
