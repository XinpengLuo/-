package 左神.字符串.自定义字符串排序;

public class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char temp = order.charAt(i);
            for(int j = 0; j < count[temp - 'a']; j++)
                sb.append(temp);
            count[temp - 'a'] = 0;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0)
                for(int j = 0; j < count[i]; j++)
                    sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }
}
