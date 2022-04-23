package 自己写的排序专题.每日练习;

import java.util.Arrays;

public class Solution {
    public void quickSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int base = arr[left];
        int i = left;
        int j = right;
        while(left < right){
            while(left < right && arr[right] >= base)
                right--;
            while(left < right && arr[left] <= base)
                left++;
            swap(arr, left, right);
        }
        swap(arr,i,left);
        quickSort(arr,i,left - 1);
        quickSort(arr,left + 1, j);
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, cur = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j])
            {
                temp[cur] = arr[i];
                i++;
            }
            else{
                temp[cur] = arr[j];
                j++;
            }
            cur++;
        }
        while(i <= mid){
            temp[cur++] = arr[i++];
        }
        while(j <= right){
            temp[cur++] = arr[j++];
        }
        for(int k = 0; k < temp.length; k++){
            arr[left + k] = temp[k];
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,1,-1,5,3,2,4};
        solution.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
