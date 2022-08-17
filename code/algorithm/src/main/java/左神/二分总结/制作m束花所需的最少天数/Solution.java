package 左神.二分总结.制作m束花所需的最少天数;

import java.util.concurrent.locks.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int res = -1;
        int left = 1, right = (int) Math.pow(10,9);
        while(left <= right){
            int mid = left + (right - left) / 2;
            int temp = k;
            int count = m;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    temp--;
                    if(temp == 0){
                        count--;
                        temp = k;
                    }
                }
                else
                    temp = k;
            }
            if(count <= 0){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        ReentrantLock lock = new ReentrantLock();
        Solution solution = new Solution();
        System.out.println(solution.minDays(arr, 3, 2));
    }
}