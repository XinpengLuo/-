package 左神中级班.第三节.找到最长的有效括号子串;

import java.util.Arrays;

public class Solution {
    public int maxSonString(String s){
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            if(s.charAt(i) == '(')
                dp[i] = 0;
            else{
                if(i - 1 >= 0 && i - 1 - dp[i - 1] >= 0){ //其实这里可以直接从i = 1 开始算 因为i = 0 肯定为0
                    if(s.charAt(i - 1 - dp[i - 1]) == ')')
                        dp[i] = 0;
                    else
                        {
                            dp[i] =i - 1 - dp[i - 1] - 1 >= 0 ?  2 + dp[i - 1] + dp[i - 1 - dp[i - 1] - 1] : 2 + dp[i - 1];
                        }
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans,i);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSonString("())()(())()))(())"));
    }
}
