package 主要练习.暴力递归和动态规划.动态规划.刷题.分披萨;

public class Solution {
    public int maxSizeSlices(int[] slices) {
        return Math.max(help(slices,0,slices.length - 1,0),help(slices,1,slices.length,0));
    }
    public int help(int[] slices, int index, int end, int times){
        if(times == slices.length / 3 || index >= end)
            return 0;
        return Math.max(slices[index] + help(slices,index + 2,end,times + 1),help(slices,index + 1,end,times));
    }
    public int dp(int[] slices){
        //要头不要尾
        int[][] dpHead = new int[slices.length][slices.length / 3 + 1];
        for(int i = dpHead.length - 2; i >= 0; i--)
            for(int j = dpHead[0].length - 2; j >= 0; j--)
                dpHead[i][j] = Math.max(slices[i] + getValue(dpHead,i + 2,j + 1),dpHead[i + 1][j]);
        //要尾不要头
        int[][] dpTail = new int[slices.length + 1][slices.length / 3 + 1];
        for(int i = dpTail.length - 2; i >= 1; i--)
            for(int j = dpTail[0].length - 2; j >= 0; j--)
                dpTail[i][j] = Math.max(slices[i] + getValue(dpTail,i + 2,j + 1),dpTail[i + 1][j]);
        return Math.max(dpHead[0][0],dpTail[1][0]);
    }
    public int getValue(int[][] dp, int i, int j){
        if(i >= dp.length)
            return 0;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8,9,8,6,1,1};
        System.out.println(solution.maxSizeSlices(arr));
        System.out.println(solution.dp(arr));
    }
}
