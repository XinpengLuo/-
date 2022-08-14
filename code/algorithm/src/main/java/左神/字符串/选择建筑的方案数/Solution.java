package 左神.字符串.选择建筑的方案数;

public class Solution {
    public long numberOfWays(String s) {
        long res = 0;
        //计算0的
        long[] count = new long[s.length()];
        count[0] = s.charAt(0) == '0' ? 1 : 0;
        for(int i = 1; i < s.length(); i++)
        {
            count[i] = count[i - 1];
            if(s.charAt(i) == '0')
                count[i]++;
        }
        int n = s.length() - 1;
        for(int i = 1; i < s.length() - 1; i++){
            char c = s.charAt(i);
            if(c == '1')
                res += (count[i - 1] * (count[n] - count[i]));
            else{
                res += (i - count[i - 1]) * (n - i - count[n] + count[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "11100";
        System.out.println(solution.numberOfWays(s));
    }
}
