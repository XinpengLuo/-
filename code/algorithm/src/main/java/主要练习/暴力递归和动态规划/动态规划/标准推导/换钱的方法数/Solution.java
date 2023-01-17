package 主要练习.暴力递归和动态规划.动态规划.标准推导.换钱的方法数;

public class Solution {
    public int getAllMethods(int[] arr, int target){
        return help(arr, target,0,0);
    }
    public int help(int[] arr, int target,int index,int tempSum){
        if(target == tempSum)
            return 1;
        if(target < tempSum)
            return 0;
        int allMethod = 0;
        for(int i = index; i < arr.length; i++)
            allMethod += help(arr,target,i,tempSum + arr[i]);
        return allMethod;
    }

    //求凑成金额的最少的硬币数量 返回的是硬币的数量
    int resLeast = Integer.MAX_VALUE;
    public void getLeastCoins(int[] arr,int index,int target, int count){
        if(index == arr.length){ //其实就想像成从左往右挨着选 每一种可以选很多张 也可以选0张 数组走完 比较当前值
            if(target == 0)
                resLeast = Math.min(resLeast,count);
        }else{
            for(int time = 0; arr[index] * time <= target; time++) //time 代表当前index所指向的钱的张数
                {
                    getLeastCoins(arr,index + 1,target - arr[index] * time,count + time);
                }
        }
    }
    public int getLeastCoinsTwo(int[] arr,int index,int target){
        if(index == arr.length){
            return target == 0 ? 0 : -1;
        }
        int res = Integer.MAX_VALUE;
        for(int time = 0; arr[index] * time <= target; time++)
        {
            int temp = getLeastCoinsTwo(arr,index + 1,target - arr[index] * time);
            if(temp == -1)
                continue;
            else
                res = Math.min(time + temp,res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int getLeastCoinsDp(int[] arr, int target){
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp[arr.length].length; i++) {
            if(i == 0)
                dp[arr.length][i] = 0;
            else
                dp[arr.length][i] = -1;
        }
        for(int i = dp.length - 2; i >= 0; i--)
            for(int j = 0; j < target + 1; j++){
                int res = Integer.MAX_VALUE;
                for(int k = 0; arr[i] * k <= j; k++){
                    int temp = dp[i + 1][j - arr[i] * k];
                    if(temp == -1)
                        continue;
                    else
                        res = Math.min(k + temp,res);
                }
                dp[i][j] = res == Integer.MAX_VALUE ? -1 : res;
            }
        return dp[0][target];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {411,412,413,414,415,416,417,418,419,420,421,422};
        System.out.println(solution.getLeastCoinsTwo(arr, 0, 9864));
        System.out.println(solution.getLeastCoinsDp(arr, 9864));
    }
    //左神版动态规划
    public int dpNew(int[] coins,int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for(int i = coins.length - 1; i >=0; i--)
            for(int j = 0; j < amount + 1; j++){
                for(int k = 0; j - coins[i] * k >= 0; k++)
                    dp[i][j] += dp[i + 1][j - coins[i] * k];
            }
        return dp[0][amount];
    }
    //左神递归版本
    public int process(int[] arr, int index,int target){
        int res = 0;
        if(index == arr.length){ //其实就想像成从左往右挨着选 每一种可以选很多张 也可以选0张 数组走完 比较当前值
            res = target == 0 ? 1 : 0;
        }else{
            for(int time = 0; arr[index] * time <= target; time++) //time 代表当前index所指向的钱的张数
                res += process(arr,index + 1,target - arr[index] * time);
        }
        return res;
    }
    //优化版本
    public int dpExce(int[] coins,int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for(int i = coins.length - 1; i >=0; i--)
            for(int j = 0; j < amount + 1; j++){
               dp[i][j] = j - coins[i] >= 0 ? dp[i][j - coins[i]] + dp[i + 1][j] : dp[i + 1][j];
            }
        return dp[0][amount];
    }
    //自己写的动态规划版本
    public int dp(int[] coins, int amount){
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i][amount] = 1;
        for(int i = dp.length - 1; i >= 0; i--)
            for(int j = amount - 1; j >= 0; j--){
                int sum = j;
                for(int k = i; k < dp.length; k++){
                    sum =sum + coins[k];
                    int temp;
                    if(sum > amount)
                        temp = 0;
                    else
                        temp = dp[k][sum];
                    dp[i][j] += temp;
                    sum = j;
                }
            }
        return dp[0][0];
    }

}
