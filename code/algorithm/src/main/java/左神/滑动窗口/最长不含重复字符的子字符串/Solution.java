package 左神.滑动窗口.最长不含重复字符的子字符串;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);
            if(set.contains(t)){
                while (s.charAt(j) != t)
                    {
                        set.remove(s.charAt(j));
                        j++;
                    }
                j++;
                set.remove(s.charAt(j));
            }
            set.add(t);
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
