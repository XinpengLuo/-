package 主要练习.字符串.词典中最长的单词;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length())
                    return s1.length() - s2.length();
                return s2.compareTo(s1);
            }
        });
        String ans = "";
        HashSet<String> set= new HashSet<>();
        set.add("");
        for(int i = 0; i < words.length; i++){
            if(set.contains(words[i].substring(0,words[i].length()- 1))){
                ans = words[i];
                set.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        Solution solution = new Solution();
        System.out.println(solution.longestWord(str));
    }
}
