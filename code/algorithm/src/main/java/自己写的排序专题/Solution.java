package 自己写的排序专题;

import 左神.树专题.公共节点.力扣.TreeNode;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int target = arr[i];
        while (i < j){
            while (i < j && arr[j] >= target)
                j--;
            while (i < j && arr[i] <= target)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSort(arr,left,i - 1);
        quickSort(arr,i + 1,right);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void mergeSort(int[] arr, int i, int j){
        if(i >= j)
            return;

        int mid = i + (j - i) / 2;
        mergeSort(arr,i,mid);
        mergeSort(arr,mid + 1, j);
        int[] temp = new int[j - i + 1];
        int left = i, right = mid + 1, index = 0;
        while(left <= mid || right <= j){
            int x = left > mid ? Integer.MAX_VALUE : arr[left];
            int y = right > j ? Integer.MAX_VALUE : arr[right];
            if(x < y)
            {
                temp[index] = x;
                left++;
            }
            else
            {
                temp[index] = y;
                right++;
            }
            index++;
        }
        for(int k = i; k <= j; k++)
            arr[k] = temp[k - i];
    }



    public static void main(String[] args) {
        int[] arr = {3,1,5,7,1,3,5,2};
        Solution solution = new Solution();
        solution.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}