package 左神.位运算.最长的美好子字符串;

public class Solution {
    public String longestNiceSubstring(String s) {
        int max = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            int low = 0, up = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c >= 'a' && c <= 'z')
                    low |= (1 << (c - 'a'));
                else
                    up |= (1 << (c - 'A'));
                if(low == up){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return max == 0 ? "" : res;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubstring(s));
    }
}
