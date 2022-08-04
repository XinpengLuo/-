package 左神.暴力递归和动态规划.递归和回溯.刷题.统计打字方案数;

public class Solution {
    int mod = (int) (Math.pow(10,9) + 7);
    public int countTexts(String pressedKeys) {
        return dfs(pressedKeys,0);
    }
    public int dfs(String pressKeys, int index){
        if(index == pressKeys.length())
            return 1;
        char c = pressKeys.charAt(index);
        int res = 0;
        int maxLength = c == '7' || c == '9' ? 4 : 3;
        int pre = index;
        while(index < pressKeys.length() && pressKeys.charAt(index) == c && index - pre + 1 <= maxLength)
            index++;
        for(int i = pre; i < index; i++)
            res =  (res + dfs(pressKeys,i + 1)) % mod;
        return res % mod;
    }

    public int dp(String pressedKeys){
        int[] dp = new int[pressedKeys.length() + 1];
        dp[dp.length - 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            char c = pressedKeys.charAt(i);
            int maxLength = c == '7' || c == '9' ? 4 : 3;
            int j = i;
            while(j < pressedKeys.length() && pressedKeys.charAt(j) == c && j - i + 1 <= maxLength)
                j++;
            for(int k = i; k < j; k++)
                dp[i] = (dp[i] + dp[k + 1]) % mod;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "2223322233222332223322233587234";
        System.out.println(solution.countTexts(s));
        System.out.println(solution.dp(s));
    }
}
