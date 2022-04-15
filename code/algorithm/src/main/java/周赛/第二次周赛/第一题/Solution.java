package 周赛.第二次周赛.第一题;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char key = entry.getKey();
            int countWord2 = map2.containsKey(key) ? map2.get(key) : 0;
            if(map1.get(key) - countWord2 > 3)
                return false;
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            char key = entry.getKey();
            int countWord1 = map1.containsKey(key) ? map1.get(key) : 0;
            if(map2.get(key) - countWord1 > 3)
                return false;
        }
        return true;
    }

    public boolean checkAlmostEquivalentTwo(String word1, String word2) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            a[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            b[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(Math.abs(a[i] - b[i]) > 3)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "zzzyyy";
        String b = "iiiiii";
        System.out.println(solution.checkAlmostEquivalent(a, b));
        System.out.println(solution.checkAlmostEquivalentTwo(a,b));
    }
}
