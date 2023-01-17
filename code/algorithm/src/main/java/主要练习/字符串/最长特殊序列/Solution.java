package 主要练习.字符串.最长特殊序列;

public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(),b.length());
    }
}
