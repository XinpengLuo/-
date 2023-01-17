package 主要练习.字符串.连续字符;

public class Solution {
    public int maxPower(String s) {
        int ans = 0;
        int count = 0;
        char preChar = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == preChar)
                count++;
            else
            {
                count = 1;
                preChar = s.charAt(i);
            }
            ans = Math.max(count,ans);
        }
        return ans;
    }
}
