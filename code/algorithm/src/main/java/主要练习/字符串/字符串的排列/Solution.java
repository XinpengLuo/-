package 主要练习.字符串.字符串的排列;

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m)
            return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < n; i++)
            cnt1[s1.charAt(i) - 'a']++;
        int index = 0, j = 0;
        while (index < m){
            cnt2[s2.charAt(index) - 'a']++;
            if(index >= n - 1){
                if(Arrays.equals(cnt1,cnt2))
                    return true;
                cnt2[s2.charAt(j) - 'a']--;
                j++;
            }
            index++;
        }
        return false;
    }
}
