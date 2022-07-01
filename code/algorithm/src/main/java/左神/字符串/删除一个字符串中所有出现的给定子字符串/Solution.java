package 左神.字符串.删除一个字符串中所有出现的给定子字符串;

public class Solution {
    public static String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }
public static void main(String[] args) {
    String s = "daabcbaabcbc";
    System.out.println(removeOccurrences(s,"abc"));
}
}
