package 左神.暴力递归和动态规划.动态规划.刷题.最大整除子集;

import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

import java.util.*;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        int index = -1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        if(max == 1)
        {
            res.add(nums[0]);
            return res;
        }
        int pre = nums[index];
        int count = max;
        while (res.size() != count){
            if(dp[index] == max && pre % nums[index] == 0) {
                res.add(nums[index]);
                pre = nums[index];
                max--;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,16,8};
        Solution solution = new Solution();
        for (Integer integer : solution.largestDivisibleSubset(arr)) {
            System.out.println(integer);
        }
    }
}
