package 左神.数组和矩阵.刷题.分割字符串的方案数;

public class Solution {
    public int numWays(String s) {
        int mod = 1000000007;
        int[] pre = new int[s.length()];
        pre[0] = s.charAt(0) == '1' ? 1 : 0;
        for(int i = 1; i < s.length(); i++)
            pre[i] = pre[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        int n = s.length();
        if(pre[n - 1] == 0)
            return (int) (((long)(n - 1) * (long)(n - 2) / 2) % mod);
        if(pre[n - 1] % 3 != 0)
            return 0;
        long x = 0, y = 0;
        for(int i = 0; i < n; i++){
            if(pre[i] == pre[n - 1] / 3)
                x++;
            if(pre[i] == (pre[n - 1] / 3 + 1))
                y++;
        }
        return (int) (x * y % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10101";
        System.out.println(solution.numWays(s));
    }
}
