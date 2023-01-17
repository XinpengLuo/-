package 周赛.第88场双周赛.删除字符使频率相同;

import java.util.*;

public class Solution {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : count) {
            if(i == 0)
                continue;
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        if(map.size() == 1)
        {
            if(map.firstKey() == 1 || map.get(map.firstKey()) == 1)
                return true;
            return false;
        }
        if(map.size() >= 3)
            return false;
        if(map.lastKey() - map.firstKey() == 1 && (map.get(map.firstKey()) == 1 ||map.get(map.lastKey()) == 1))
            return true;
        return false;
    }

}
