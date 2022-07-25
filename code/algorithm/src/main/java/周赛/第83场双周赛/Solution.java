package 周赛.第83场双周赛;

import java.util.*;

public class Solution {
//    buses = [10,20], passengers = [2,17,18,19], capacity = 2
//    输出：16
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int passenger : passengers) {
            set.add(passenger);
        }
        int j = 0;
        for(int i = 0; i < buses.length; i++){
            int count = 0;
            while (count < capacity && j < passengers.length){
                if(passengers[j] <= buses[i]){
                    if(!set.contains(passengers[j] - 1))
                        res = passengers[j] - 1;
                    j++;
                    count++;
                }
                else
                    break;
            }
            if(count < capacity && !set.contains(buses[i]))
                res = buses[i];
        }
        return res;
    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        int[] diff = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int left = 0, right = 100001;
        int target = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int i : diff) {
                if(i > mid)
                    count += (i - mid);
            }
            if(count > k)
                left = mid + 1;
            else{
                target = mid;
                right = mid - 1;
            }
        }
        int count = 0;
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] > target){
                count += diff[i] - target;
                diff[i] = target;
            }
        }
        if(count < k){
            Arrays.sort(diff);
            k -= count;
            for(int i = diff.length - 1; i >= 0 && k > 0; i--)
                if(diff[i] >= 1) {
                    diff[i]--;
                    k--;
                }
        }
        long res = 0;
        for (int i : diff) {
            long temp = i * i;
            res += temp;
        }
        return res;
    }

    public int validSubarraySize(int[] nums, int threshold) {
        int left = 1, right = nums.length;
        while (left <= right){
            int k = left + (right - left) / 2;
            float target = threshold / k;
            int index = 0;
            int count = 0;
            while (index < nums.length){
                if(nums[index] > target)
                    count++;
                else
                    count = 0;
                if(count >= k)
                    return k;
                index++;
            }
            left = k + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int[] a = {10,20};
        int[] b= {2,17,18,19};
        Solution solution = new Solution();
        System.out.println(solution.latestTimeCatchTheBus(a, b, 2));
//        int[] a = {10,10,10,11,5};
//        int[] b= {1,0,6,6,1};
//        Solution solution = new Solution();
//        System.out.println(solution.minSumSquareDiff(a, b, 11, 27));
    }
}
