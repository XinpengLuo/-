package 左神.滑动窗口.替换子串得到平衡字符串;

public class Solution {
    public int balancedString(String s) {
        int res = s.length();
        int n = s.length() / 4;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'A']++;
        if(count['Q' - 'A'] == n && count['W' - 'A'] == n && count['E' - 'A'] == n && count['R' - 'A'] == n)
            return 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'A';
            count[temp]--;
            while (j <= i && count['Q' - 'A'] <= n && count['W' - 'A'] <= n && count['E' - 'A'] <= n && count['R' - 'A'] <= n ){
                res = Math.min(res, i - j + 1);
                count[s.charAt(j) - 'A']++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "QWER";
        System.out.println(solution.balancedString(str));
    }
}
