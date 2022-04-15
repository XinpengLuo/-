package 周赛.第十一次周赛.第一题;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if(word.startsWith(pref))
                count++;
        }
        return count;
    }
}
