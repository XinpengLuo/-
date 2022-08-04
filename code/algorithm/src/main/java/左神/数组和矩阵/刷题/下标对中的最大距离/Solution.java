package 左神.数组和矩阵.刷题.下标对中的最大距离;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i = 0; i < nums1.length; i++){
            int left = 0, right = nums2.length - 1;
            int temp = -1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums2[mid] >= nums1[i]){
                    temp = mid;
                    left = mid + 1;
                }else
                    right = mid - 1;
            }
            if(temp == -1 || temp < i)
                continue;
            max = Math.max(max, temp - i);
        }
        return max;
    }
}
