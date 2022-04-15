package 左神.滑动窗口.最小覆盖子串;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        int success = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        success = map.size();
        HashMap<Character,Integer> window = new HashMap<>();
        int j = 0;
        int length = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            window.put(temp,window.getOrDefault(temp,0) + 1);
            if(window.get(temp).equals(map.get(temp)))
                success--;
            while (success == 0){
                if(i - j < length)
                {
                    length = i - j + 1;
                    start = j;
                }
                char left = s.charAt(j);
                if(window.get(left).equals(map.get(left)))
                    success++;
                window.put(left,window.get(left) - 1);
                j++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start,start + length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s,t));
    }
}
