package 左神.字符串.解码字母到整数映射;

public class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            if(i + 2 < s.length() && s.charAt(i + 2) == '#')
                {
                    sb.append((char)('j' + (Integer.parseInt(s.substring(i,i + 2)) - 10)));
                    i += 3;
                }
            else{
                sb.append((char)('a' + (s.charAt(i) - '1')));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "10#11#12";
        System.out.println(solution.freqAlphabets(str));
    }
}
