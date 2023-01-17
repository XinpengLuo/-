package 主要练习.字符串.无重复字符的最长字串;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashSet<Character> hashSet = new HashSet<>();
        int res = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while (j < s.length() && hashSet.add(s.charAt(j)))
                {
                    j++;
                }
            res = Math.max(res,j - i);
            System.out.println(j - i);
            hashSet.remove(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
