package 左神.字符串.匹配子序列的单词数;

import java.util.HashMap;

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        int res = 0;
        for (String temp : map.keySet()) {
            if(temp.length() > s.length())
                continue;
            int j = 0;
            for(int i = 0; i < s.length() && j < temp.length(); i++)
                if(s.charAt(i) == temp.charAt(j))
                    j++;
            if(j == temp.length())
                res += (map.get(temp));
        }
        return res;
    }
}
