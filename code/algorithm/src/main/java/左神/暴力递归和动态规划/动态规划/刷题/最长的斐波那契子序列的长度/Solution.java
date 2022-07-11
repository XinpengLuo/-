package 左神.暴力递归和动态规划.动态规划.刷题.最长的斐波那契子序列的长度;

import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++){
                int a = arr[i], b = arr[j];
                int temp = 2;
                while (set.contains(a + b)){
                    temp++;
                    int target = a + b;
                    a = b;
                    b = target;
                    res = Math.max(res,temp);
                }
            }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Solution solution = new Solution();
        System.out.println(solution.lenLongestFibSubseq(arr));
    }
}
