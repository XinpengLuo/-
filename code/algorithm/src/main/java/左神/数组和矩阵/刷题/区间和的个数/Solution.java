package 左神.数组和矩阵.刷题.区间和的个数;

import java.util.*;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] count = new long[nums.length];
        int res = 0;
        for(int i = 0; i < count.length; i++)
        {
            sum += nums[i];
            count[i] = sum;
            if(count[i] >= lower && count[i] <= upper)
                res++;
        }
        List<Long> list = new ArrayList<>();
        list.add(count[0]);
        for(int i = 1; i < nums.length; i++)
        {
            int min = findLess(list,count[i] - lower);
            int max = findGreat(list,count[i] - upper);
            if(min != -1 && max != -1 && min >= max)
                res += (min - max) + 1;
            insert(list,count[i]);
        }
        return res;
    }
    public int findGreat(List<Long> list, long target){
        //找到第一个大于等于target的下标
        int res = -1;
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) >= target){
                right = mid - 1;
                res = mid;
            }
            else
                left = mid + 1;
        }
        return res;
    }
    public int findLess(List<Long> list, long target){
        //找到最后一个小于等于 target的下标
        int res = -1;
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) <= target){
                res = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return res;
    }
    public void insert(List<Long> list, long num){
        int left = 0, right = list.size() - 1;
        int index = -1;
        //找到最后一个小于它的元素的下标
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) < num){
                left = mid + 1;
                index = mid;
            }
            else
                right = mid - 1;
        }
        list.add(index + 1, num);
    }
}
