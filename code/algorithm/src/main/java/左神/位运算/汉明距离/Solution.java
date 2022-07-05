package 左神.位运算.汉明距离;

import java.util.*;

public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((x & (1 << i)) ^ (y & (1 << i))) != 0)
                count++;
        }
        return count;
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
            while (i < j && arr[i] <= target)
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quickSort(arr,left, i - 1);
        quickSort(arr,i + 1, right);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,12,1,4,1,5,4};
        Solution solution = new Solution();
        solution.quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
