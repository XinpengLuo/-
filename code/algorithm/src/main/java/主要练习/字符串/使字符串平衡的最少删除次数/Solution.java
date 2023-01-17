package 主要练习.字符串.使字符串平衡的最少删除次数;

public class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == 'a' ? 0 : 1;
        int countB = s.charAt(0) == 'b' ? 1 : 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == 'b')
                {
                    dp[i] = dp[i - 1];
                    countB++;
                }
            else
                dp[i] = Math.min(countB, 1 + dp[i - 1]);

        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "bbaaaaabb";
        System.out.println(solution.minimumDeletions(word));
    }
}
