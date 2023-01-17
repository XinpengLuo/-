package 主要练习.字符串.亲密字符串;

public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[goal.charAt(i) - 'a']++;
            if(s.charAt(i) != goal.charAt(i))
                count++;
        }
        if(count > 2)
            return false;
        boolean isOverTwo = false;
        for(int i = 0; i < cnt1.length; i++)
        {
            if(cnt1[i] != cnt2[i])
                return false;
            if(cnt1[i] > 1)
                isOverTwo = true;
        }
        if(count == 2)
            return true;
        if(count == 0 && isOverTwo)
            return true;
        return false;
    }
}
