package 主要练习.字符串.最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') //因为单词很有可能也是以空格结尾的 所以要把空格去掉
            index--;
        int length = 0;
        while (index >= 0 && s.charAt(index) != ' '){
            length++;
            index--;
        }
        return length;
    }
}
