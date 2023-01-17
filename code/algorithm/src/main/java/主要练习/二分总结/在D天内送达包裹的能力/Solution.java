package 主要练习.二分总结.在D天内送达包裹的能力;

import java.util.Arrays;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int weight : weights) {
            max = Math.max(max,weight);
        }
        int left = max;
        int right = max * weights.length;
        int res = -1;
        Arrays.sort(weights);
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int temp = 1;
            int sum = 0;
            for (int weight : weights) {
                if(sum + weight >middle){
                    sum = 0;
                    temp++;
                }
                sum += weight;
            }
            if(temp <= days) {
                res = middle;
                right = middle - 1;
            }
            else
                left = middle + 1;
        }
        return res;
    }
}
