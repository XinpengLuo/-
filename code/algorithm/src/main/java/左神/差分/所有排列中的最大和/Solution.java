package 左神.差分.所有排列中的最大和;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] temp = new int[nums.length];
        for (int[] request : requests) {
            int start = request[0];
            int end = request[1];
            temp[start]++;
            if(end + 1 < nums.length)
                temp[end + 1]--;
        }
        long res = 0;
        Arrays.sort(nums);
        for(int i = 1; i < temp.length; i++)
            temp[i] = temp[i] + temp[i - 1];
        Arrays.sort(temp);
        int mod = 1000000007;
        for(int i = temp.length - 1; i >= 0 && temp[i] > 0; i--){
            res += (long)temp[i] * nums[i];
        }
        return (int) (res % mod);
    }

    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                temp = getNum(Math.max(temp, nums[j]), Math.min(temp, nums[j]));
                if (temp % k != 0)
                    break;
                if (temp == k)
                    res++;

            }
        }
        return res;
    }
    public int getNum(int a, int b){
        return b == 0 ? a : getNum(b, a % b);
    }

    public void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int left = i;
        int right = j;
        int target = arr[i];
        while(i < j){
            while (i < j && arr[j] >= target)
                j--;
            while(i < j && arr[i] <= target)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSort(arr,left,i - 1);
        quickSort(arr,i + 1,right);
    }

    public void mergeSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int mid = (i + j) / 2;
        mergeSort(arr,i,mid);
        mergeSort(arr,mid + 1,j);
        int[] temp = new int[j - i + 1];
        int left = i, right = mid + 1;
        int index = 0;
        while(left <= mid || right <= j){
            int a = left <= mid ? arr[left] : Integer.MAX_VALUE;
            int b = right <= j ? arr[right] : Integer.MAX_VALUE;
            if(a < b)
                temp[index] = arr[left++];
            else
                temp[index] = arr[right++];
            index++;
        }
        for(int k = i; k <= j; k++)
            arr[k] = temp[k - i];
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insertHeap(int[] arr, int index){
        int parentIndex = (index - 1) / 2;
        while(arr[parentIndex] < arr[index]){
            swap(arr,index,parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    public void heapFy(int[] arr, int size){
        int index = 0;
        int leftIndex = index * 2 + 1;
        while(leftIndex <= size){
            int largerIndex = leftIndex + 1 <= size && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
            largerIndex = arr[index] > arr[largerIndex] ? index : largerIndex;
            if(index == largerIndex)
                return;
            swap(arr,index,largerIndex);
            index = largerIndex;
            leftIndex = index * 2 + 1;
        }
    }
    public void heapSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            insertHeap(arr,i);
        int size = arr.length;
        while(size-- > 0){
            swap(arr,0,size);
            heapFy(arr,size - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,1,5,90,34,2,3,56,9,4};
        Solution solution = new Solution();
        solution.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
