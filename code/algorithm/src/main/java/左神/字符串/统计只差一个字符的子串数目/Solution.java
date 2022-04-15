package 左神.字符串.统计只差一个字符的子串数目;

public class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < t.length(); j++){
                int diff = 0;
                for(int k = 0; k + i < s.length() && k + j < t.length(); k++){
                    if(s.charAt(i + k) != t.charAt(j + k))
                        diff++;
                    if(diff > 1)
                        break;
                    if(diff == 1)
                        count++;
                }
            }
        return count;
    }


    public static void main(String[] args) {
        String s = "aba", t = "baba";
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings(s, t));
    }
}
