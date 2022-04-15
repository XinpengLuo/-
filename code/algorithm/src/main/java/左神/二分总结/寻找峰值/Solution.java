package 左神.二分总结.寻找峰值;

public class Solution {
    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = (l+r) / 2;
            if(nums[m] < nums[m + 1])
             l = m + 1;
            else r = m;
        }
        return l;
    }
    public int test(int target){
        double res = (Math.sqrt(Double.valueOf(target) * 8) + 1);
        int a = 1 | 2;
        return (int) res;
    }

}
