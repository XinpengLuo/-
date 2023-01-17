package 主要练习.暴力递归和动态规划.动态规划.刷题.分隔数组以得到最大和;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return help(arr,k,0);
    }
    public int help(int[] arr, int k, int index){
        if(index >= arr.length)
            return 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            if(index + i >= arr.length)
                continue;
            int temp = findMax(arr,index,index + i);
            res = Math.max(res,temp * (i + 1) + help(arr,k,index + i + 1));
        }
        return res;
    }
    public int dp(int[] arr, int k){
        int[] dp = new int[arr.length];
        for(int i = dp.length - 1; i >= 0; i--){
            int res = 0;
            for(int j = 0; j < k; j++){
                if(i + j >= dp.length)
                    continue;
                int temp = findMax(arr,i,i + j);
                if(i + j + 1 >= dp.length)
                    res = Math.max(res,temp * (j + 1) + 0);
                else
                    res = Math.max(res,temp * (j + 1) + dp[i + j + 1]);
            }
            dp[i] = res;
        }
        return dp[0];
    }
    public int findMax(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++)
            max = Math.max(max,arr[i]);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(solution.maxSumAfterPartitioning(arr, 3));
        System.out.println(solution.dp(arr, 3));
    }
}
