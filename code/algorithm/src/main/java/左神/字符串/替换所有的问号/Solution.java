package 左神.字符串.替换所有的问号;

public class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '?')
            {
                for(char c = 'a'; c <= 'c'; c++)
                    if((i == 0 || sb.charAt(sb.length() - 1) != c) && (i + 1 == s.length() || c != s.charAt(i + 1)))
                    {
                        temp = c;
                        break;
                    }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
