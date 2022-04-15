package 左神.字符串.字符串中单词的个数;

public class Solution {
    public int findWords(String s){
        char preChar = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && preChar != ' ')
                count++;
            preChar = s.charAt(i);
        }
        return count;
    }
}
