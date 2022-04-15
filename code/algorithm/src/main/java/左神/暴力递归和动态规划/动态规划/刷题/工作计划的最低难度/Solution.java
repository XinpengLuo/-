package 左神.暴力递归和动态规划.动态规划.刷题.工作计划的最低难度;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        return help(jobDifficulty,d,0);
    }
    public int help(int[] jobDifficulty, int d, int index){
        if(jobDifficulty.length - index < d)
            return 50000;
        if(d == 0)
        {
            if(index >= jobDifficulty.length)
                return 0;
            return 50000;
        }

        int max = 0, res = 50000;
        for(int i = index; i < jobDifficulty.length; i++){
            max = Math.max(max,jobDifficulty[i]);
            res = Math.min(res,max + help(jobDifficulty,d - 1,i + 1));
        }
        return res;
    }
    public int dp(int[] jobDifficulty, int d){
        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        for(int i = 0; i < dp[0].length - 1; i++)
            dp[0][i] = 50000;
        for(int i = 1; i < dp.length; i++)
            for(int j = 0; j < dp[i].length; j++){
                if(jobDifficulty.length - j < i)
                    dp[i][j] = 50000;
                else{
                    int max = 0, res = 50000;
                    for(int k = j; k < jobDifficulty.length; k++){
                        max = Math.max(max,jobDifficulty[k]);
                        res = Math.min(res,max + dp[i - 1][k + 1]);
                    }
                    dp[i][j] = res;
                }
            }
        return dp[d][0] == 50000 ? -1 : dp[d][0];
    }

    public static void main(String[] args) {

        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.moreTest(nums1, nums2)));
//        System.out.println(Arrays.toString(solution.test(nums1, nums2)));
    }
    public int[] test(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length];
        int index = 0;
        for(int i = 0; i < nums1.length; i++){
            int j = 0;
            while (nums1[i] != nums2[j])
                j++;

            int k = j + 1;
            boolean flag = false;
            while (k < nums2.length){
                if(nums2[k] > nums2[j])
                    {
                        flag = true;
                        res[index] = nums2[k];
                        index++;
                        break;
                    }
                k++;
            }
            System.out.print(nums2[j] + " ");
            System.out.println(flag);
            if(!flag)
                {res[index] = -1;
                  index++;
                }
        }
        return res;
    }
    public int[] moreTest(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < nums2.length){
            if(stack.isEmpty() || stack.peek() > nums2[i]){
                stack.push(nums2[i]);
                i++;
                continue;
            }
            int temp = stack.pop();
            hashMap.put(temp,nums2[i]);
        }
        while (!stack.isEmpty())
            hashMap.put(stack.pop(),-1);
        int[] res = new int[nums1.length];


        for (int k = 0; k < res.length; k++) {
            res[k] = hashMap.get(nums1[k]);
        }
        return res;
    }
}