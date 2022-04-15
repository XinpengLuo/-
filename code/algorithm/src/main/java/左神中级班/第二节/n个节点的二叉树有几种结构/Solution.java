package 左神中级班.第二节.n个节点的二叉树有几种结构;

public class Solution {
    public int getNumberTrees(int n){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int res = 0;
        for(int i = 0; i <= n - 1; i++){
            res = res + getNumberTrees(i) * getNumberTrees(n - i - 1);
        }
        return res;
    }
    public int dp(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            for(int j = 0; j <= i - 1; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getNumberTrees(12));
        System.out.println(solution.dp(1222));
    }
}
