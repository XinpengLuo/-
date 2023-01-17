package 主要练习.暴力递归和动态规划.动态规划.刷题.跳跃游戏VII;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        return help(s,minJump,maxJump,0);
    }
//    i + minJump <= j <= min(i + maxJump, s.length - 1) 且
//    s[j] == '0'.
    public boolean help(String s, int minJump, int maxJump, int index){
        System.out.println(index);
        if(index == s.length() - 1)
            return true;
        boolean flag = false;
        for(int j = index + 1; j < s.length(); j++){
            if(index + minJump <= j && Math.min(index + maxJump,s.length() - 1) >= j && s.charAt(j) == '0')
                {
                    flag = flag || help(s,minJump,maxJump,j);
                    if(flag)
                        break;
                }
        }
        return flag;
    }
    public boolean dp(String s, int minJump, int maxJump){
        boolean[] dp = new boolean[s.length()];
        dp[s.length() - 1] = true;
        for(int i = dp.length - 2; i >= 0; i--)
           {
               boolean flag = false;
//               if(s.charAt(i) != '0')
               for(int j = i + 1; j < s.length(); j++){
                    if(i + minJump <= j && Math.min(i + maxJump,s.length() - 1) >= j && s.charAt(j) == '0'){
                        flag = flag || dp[j];
                        if(flag)
                            break;
                }
            }
               dp[i] = flag;
           }
        return dp[0];
    }
    public static void main(String[] args) {
        String s = "011010";
        Solution solution = new Solution();
        System.out.println(solution.canReach(s, 2, 3));
        System.out.println(solution.dp(s,2,3));
    }
}
