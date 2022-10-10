package 左神.数组和矩阵.刷题.引爆最多的炸弹;

import 面试真题.华为机试.最长公共子串.Main;

public class Solution {
    public int maximumDetonation(int[][] bombs) {
        return 0;
    }
    public int trap(int[] height) {
        int res = 0;
        int left = height[0], right = height[height.length - 1] ;
        int i = 1, j = height.length - 2;
        while (i <= j){
            if(left < right){
                res += Math.max(left - height[i],0);
                left = Math.max(left,height[i]);
                i++;
            }else{
                res += Math.max(right - height[j], 0);
                right = Math.max(right,height[j]);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(arr));
    }
}
