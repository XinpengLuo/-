package 主要练习.二分总结.转变数组后最接近目标值的数组和;

import java.util.*;

public class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr[arr.length - 1];
        int rightRes = Integer.MAX_VALUE, leftRes = Integer.MAX_VALUE;
        int leftIndex = 0, rightIndex = 0;
        while (left <= right){
            int val = left + (right - left) / 2;
            int count = bs(arr,val);
            int sum = count * val;
            for(int i = 0; i < arr.length - count; i++)
                sum += arr[i];
            if(sum >= target) {
                rightIndex = val;
                right--;
                rightRes = Math.abs(sum - target);
            }
            else {
                leftIndex = val;
                left++;
                leftRes = Math.abs(sum - target);
            }
        }
        return leftRes <= rightRes ? leftIndex : rightIndex;
    }
    //求出大于target的个数
    public int bs(int[] arr, int target){
        int index = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > target){
                index = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return index == -1 ? 0 : arr.length - index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,5};
        System.out.println(solution.findBestValue(arr, 10));
    }
}
