package 左神.差分.航班预订统计;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int temp = booking[2];
            diff[i - 1] += temp;
            if(j < n)
                diff[j] -= temp;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for(int i = 1; i < res.length; i++)
            res[i] = res[i - 1] + diff[i];
        // 1 0 0 -1
        //1 1 1 0
        return res;
    }
}
