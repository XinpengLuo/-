package 主要练习.二分总结.适龄的朋友;

import java.util.Arrays;

public class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int sum = 0;
        int left = 0;
        // 0.5x + 7 < y <= x
        int right = 0;
        for(int i = 0; i < ages.length; i++) {
            if(ages[i] < 15)
                continue;
            left = i;
            while(left >= 0 && ages[left] > 0.5 * ages[i] + 7)
                left--;
            right = i;
            while(right < ages.length && ages[right] == ages[i])
                right++;
            sum += (right - 1 - (left + 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {20,30,100,110,120};
        System.out.println(s.numFriendRequests(arr));
    }
}
