package 面试真题.华为机试.字符串通配符;

import java.util.*;

/**
 * @author luoxinpeng
 */
public class Solution{

    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int target = arr[i];
        while(left < right){
            while(left < right && arr[right] >= target)
                right--;
            while(left < right && arr[left] <= target)
                left++;
            swap(arr,left,right);
        }
        swap(arr,i,left);
        quickSort(arr,i,left - 1);
        quickSort(arr,left + 1,j);
    }

    public void mergerSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergerSort(arr,left,mid);
        mergerSort(arr,mid + 1,right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while(i <= mid || j <= right){
            int x = i <= mid ? arr[i] : Integer.MAX_VALUE;
            int y = j <= right ? arr[j] : Integer.MAX_VALUE;
            temp[index] = x < y ? x : y;
            if(x < y)
                i++;
            else
                j++;
            index++;
        }
        for(int k = left; k <= right; k++)
            arr[k] = temp[k - left];
    }


    public void insertHeap(int[] arr, int index){
        int parentIndex = (index - 1) / 2;
        while(arr[index] > arr[parentIndex]){
            swap(arr,index,parentIndex);
            index = parentIndex;
            parentIndex = (index - 1)/ 2;
        }
    }

    public void heapFy(int[] arr, int heapSize){
        int index = 0;
        int leftIndex = 2 * index + 1;
        while(leftIndex < heapSize){
            int largerIndex = leftIndex + 1 < heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            largerIndex = arr[largerIndex] < arr[index] ? index : largerIndex;
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
        int heapSize = arr.length;
        while(heapSize > 0){
            swap(arr,0,heapSize - 1);
            heapFy(arr,heapSize - 1);
            heapSize--;
        }

    }








    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {31,7,1,7};
        Solution solution = new Solution();
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}