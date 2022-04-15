package 左神.字符串.翻转字符串里的单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> s1 = Arrays.asList(s.split(" "));
        Collections.reverse(s1);
        return String.join(" ", s1);
    }
}
