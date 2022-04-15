package 左神中级班.第三节.括号的深度;

public class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i) == '(')
                count++;
            if(s.charAt(i) == ')')
                count--;
            res = Math.max(count,res);
        }
        return res;
    }
}
