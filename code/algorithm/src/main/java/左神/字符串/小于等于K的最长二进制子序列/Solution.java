package 左神.字符串.小于等于K的最长二进制子序列;

public class Solution {
    public int longestSubsequence(String s, int k) {
        int temp = 0;
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int num = s.charAt(i) - '0';
            if(num == 0)
                continue;
            if(s.length() - 1 - i >= 30){
                count++;
                continue;
            }
            if(temp + (1 << (s.length() - 1 - i)) <= k)
                temp += (1 << (s.length() - 1 - i));
            else
                count++;
        }
        return s.length() - count;
    }
}
