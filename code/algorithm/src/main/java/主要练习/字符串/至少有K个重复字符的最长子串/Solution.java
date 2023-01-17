package 主要练习.字符串.至少有K个重复字符的最长子串;

public class Solution {
    public int longestSubstring(String s, int k) {
        return help(s,k,0,s.length() - 1);
    }
    public int help(String s, int k, int start, int end){
        if(start > end)
            return 0;
        int[] count = new int[26];
        for(int i = start; i <= end; i++)
            count[s.charAt(i) - 'a']++;
        System.out.println(start);
        for(int i = start; i <= end; i++){
            if(count[s.charAt(i) - 'a']  < k){
                int l = help(s,k,start,i - 1);
                int r = help(s,k,i + 1,end);
                return Math.max(l,r);
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("aaabb", 3));
    }
}
