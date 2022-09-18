package 左神.位运算.按位或最大的最小子数组长度;

import java.util.*;

public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] res = new int[nums.length];
        int[] state = new int[32];
        for(int i = nums.length - 1; i >= 0; i--){
            int max = 0;
            for(int j = 31; j >= 0; j--){
                int a = state[j];
                int b = (nums[i] >> j) & 1;
                if(a != 0 && b == 0)
                    max = Math.max(max, a - i + 1);
                if(b == 1)
                    state[j] = i;
            }
            res[i] = max == 0 ? 1 : max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,1,3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallestSubarrays(arr)));
    }
}
