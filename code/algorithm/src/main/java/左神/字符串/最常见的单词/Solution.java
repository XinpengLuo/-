package 左神.字符串.最常见的单词;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> words = new HashSet<>();
        for (String s : banned) {
            words.add(s);
        }
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= paragraph.length(); i++) {
            if(i < paragraph.length() && Character.isLetter(paragraph.charAt(i)))
            {
                char tmp = Character.toLowerCase(paragraph.charAt(i));
                sb.append(tmp);
            }
            else{
                if(sb.length() != 0){
                    String s = sb.toString();
                    if(!words.contains(s))
                        map.put(s,map.getOrDefault(s,0) + 1);
                    sb.setLength(0);
                }
            }
        }
        int max = 0;
        String res = "";
        for (String s : map.keySet()) {
            if(map.get(s) > max){
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] word = {"hit"};
        System.out.println(solution.mostCommonWord(s, word));
    }
}
