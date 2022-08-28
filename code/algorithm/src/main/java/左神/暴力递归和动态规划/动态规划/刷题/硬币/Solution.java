package 左神.暴力递归和动态规划.动态规划.刷题.硬币;

public class Solution {
    public int waysToChange(int n) {
        int[] arr = {25,10,5,1};
        return dpExce(arr,n);
    }

    public int dfs(int[] arr, int target, int index){
        if(index == arr.length)
            return target == 0 ? 1 : 0;
        int res = 0;
        for(int i = 0; i * arr[index] <= target; i++)
            res += dfs(arr,target - i * arr[index],index + 1);
        return res;
    }
//    public int dp(int[] arr, int target){
//        int[][] dp = new int[arr.length + 1][target + 1];
//        dp[arr.length][0] = 1;
//        for(int i = dp.length - 2; i >= 0; i--){
//            for(int k = 0; k * arr[i] <= )
//        }
//    }
    public int dpExce(int[] coins,int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for(int i = coins.length - 1; i >=0; i--)
            for(int j = 0; j < amount + 1; j++){
                dp[i][j] = j - coins[i] >= 0 ? (dp[i][j - coins[i]] + dp[i + 1][j]) %  1000000007: (dp[i + 1][j]) % 1000000007;
            }
        return dp[0][amount];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToChange(900750));
    }
}
