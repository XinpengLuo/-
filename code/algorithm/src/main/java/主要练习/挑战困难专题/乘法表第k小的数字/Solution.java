package 主要练习.挑战困难专题.乘法表第k小的数字;

import java.util.*;

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int right = m * n, left = 1;
        int res = -1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            int count = 0;
            for(int i = 1; i <= m; i++) {
                count += Math.min(middle / i, n);
            }
            if(count >= k)
            {
                res = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return res;
    }
    public void quickSort(int[] arr, int i, int j){
        if(i >= j) {
            return;
        }

        int left = i;
        int right = j;
        int target = arr[i];
        while(i < j){
            while (i < j && arr[j] >= target) {
                j--;
            }
            while ( i < j && arr[i] <= target){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,left);
        quickSort(arr,left, i - 1);
        quickSort(arr,i + 1, right);
    }
    public void swap(int[] arr, int i, int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid || j <= right){
            int a = i <= mid ? arr[i] : Integer.MAX_VALUE;
            int b = j <= right ? arr[j] : Integer.MAX_VALUE;
            if(a <= b){
                temp[index] = a;
                i++;
            }
            else{
                temp[index] = b;
                j++;
            }
            index++;
        }
        for(int k = left; k <= right; k++){
            arr[k] = temp[k - left];
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,45,65,1,2,5};
        Solution solution = new Solution();
        solution.mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
