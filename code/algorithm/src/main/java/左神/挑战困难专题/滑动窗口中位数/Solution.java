package 左神.挑战困难专题.滑动窗口中位数;

import java.util.*;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int index = 0;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++)
            temp[i] = nums[i];
        Arrays.sort(temp);
        res[index] = k % 2 != 0 ? temp[k / 2] : (((double) (temp[k / 2])) / 2 + ((double) temp[(k - 1) / 2]) / 2);
        index++;
        for(int i = k; i < nums.length; i++){
            int deleteIndex = getIndex(temp,nums[i - k]);
            temp[deleteIndex] = nums[i];
            //向前冒泡
            for(int j = deleteIndex; j < temp.length - 1; j++)
                if(temp[j + 1] < temp[j])
                    swap(temp,j,j + 1);
            //向后冒泡
            for(int j = deleteIndex; j >= 1; j--)
                if(temp[j - 1] > temp[j])
                    swap(temp,j,j - 1);
            res[index] = k % 2 != 0 ? temp[k / 2] : (((double) (temp[k / 2])) / 2 + ((double) temp[(k - 1) / 2]) / 2);
            index++;
        }
        return res;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int getIndex(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

}
