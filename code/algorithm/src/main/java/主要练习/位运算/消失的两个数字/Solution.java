package 主要练习.位运算.消失的两个数字;

import java.util.*;

public class Solution {
    public int[] missingTwo(int[] nums) {
        int temp = 0;
        for(int i = 1; i <= nums.length + 2; i++)
            temp ^= i;
        for (int num : nums) {
            temp ^= num;
        }
        int mostRightOne = 0;
        for(int i = 0; i <= 31; i++)
            if(((temp >> i) & 1) == 1)
            {
                mostRightOne = i;
                break;
            }
        int xor = 0;
        for(int i = 1; i <= nums.length + 2; i++)
            if(((i >> mostRightOne) & 1) == 1)
                xor ^= i;
        for (int num : nums) {
            if(((num >> mostRightOne) & 1) == 1)
                xor ^= num;
        }
        return new int[]{xor,xor ^ temp};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1};
        System.out.println(Arrays.toString(solution.missingTwo(arr)));
    }
}
