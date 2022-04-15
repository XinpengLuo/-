package 周赛.第十一次周赛.第三题;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
       long max = 0;
        for (int t : time) {
            max = Math.max(max,(long) t * totalTrips);
        }
        long left = 0, right = max;
        long ans = 1;
        while (left <= right){
            long mid = left + (right - left) / 2;
            long temp = 0;
            for (int t : time) {
                temp += (mid / t);
            }
            if(temp >= totalTrips){
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        System.out.println(solution.minimumTime(arr, 5));
    }
}
