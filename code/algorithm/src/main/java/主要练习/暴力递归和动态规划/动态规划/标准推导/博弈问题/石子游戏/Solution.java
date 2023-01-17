package 主要练习.暴力递归和动态规划.动态规划.标准推导.博弈问题.石子游戏;

public class Solution {
    public boolean stoneGame(int[] piles) {
        return first(piles,0,piles.length - 1) > second(piles,0,piles.length - 1);
    }
    public int first(int[] arr, int left, int right){
        if(left == right)
            return arr[left];
        return Math.max(arr[left] + second(arr,left + 1,right) , arr[right] + second(arr,left,right - 1));
    }
    public int second(int[] arr, int left, int right){
        if(left == right)
            return 0;
        return Math.min(first(arr,left + 1,right),first(arr,left,right - 1));
    }
    public boolean dp(int[] nums){
        //first表
        int[][] dpFirst = new int[nums.length][nums.length];
        //second表
        int[][] dpSecond = new int[nums.length][nums.length];
        for(int i = 0; i < dpFirst.length; i++)
            dpFirst[i][i] = nums[i];
        for(int i = 0; i < dpSecond.length; i++)
            dpSecond[i][i] = 0;
        //一共有几条对角线
        for(int k = dpFirst[0].length - 2; k >= 0; k--){
            for(int j = dpFirst[0].length - 1 , i = k; i >= 0 && j >= 0; i--,j--){
                int a = j - 1 >= 0 ? dpSecond[i][j - 1] : 0;
                int b = j - 1 >= 0 ? dpFirst[i][j - 1] : Integer.MAX_VALUE;
                dpFirst[i][j] = Math.max(nums[i] + dpSecond[i + 1][j], nums[j] + a);
                dpSecond[i][j] = Math.min(dpFirst[i + 1][j],b);
            }
        }
        int length = dpFirst[0].length;
        return dpFirst[0][length - 1] > dpSecond[0][length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,3,4,5};
        solution.dp(arr);
    }
}
