package 主要练习.字符串.字符的最短距离;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int left = -s.length(), right = 2 * s.length();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c)
                left = i;
            res[i] = i - left;
        }
        for(int j = s.length() - 1; j >= 0; j--){
            if(s.charAt(j) == c)
                right = j;
            res[j] = Math.min(res[j],right - j);
        }

        return res;
    }
}
