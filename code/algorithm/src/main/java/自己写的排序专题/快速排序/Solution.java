package 自己写的排序专题.冒泡排序;

import java.util.Arrays;

public class Solution {
    public void quickSort(int[] arr, int left, int right) {
        if(left >= right)
            return;
        int i = left;
        int j = right;
        int base = arr[left];
        while(left < right) {
            while(right > left && arr[right] >= base)
                right--;
            while(right > left && arr[left] <= base)
                left++;
            swap(arr, left, right);
        }
        swap(arr,i,left);
        quickSort(arr,i,left - 1);
        quickSort(arr,left + 1, j);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void quickSortReverse(int[] arr, int left, int right){
        if(left >= right)
            return;
        int i = left;
        int j = right;
        int base = arr[left];
        while(i < j){
            while(i < j && arr[j] <= base)
                j--;
            while(i < j && arr[i] >= base)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSortReverse(arr, left, i - 1);
        quickSortReverse(arr,i + 1, right);
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,31,3,1,5,6,2,1,-1};
        solution.quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
        solution.quickSortReverse(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
