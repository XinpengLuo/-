package 周赛.第五次周赛.第一题;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            map1.put(words1[i],map1.getOrDefault(words1[i],0) + 1);
        }
        for (int i = 0; i < words2.length; i++) {
            map2.put(words2[i],map2.getOrDefault(words2[i],0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue() == 1){
                if(map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) == 1)
                    ans++;
            }
        }
        return ans;
    }
}
