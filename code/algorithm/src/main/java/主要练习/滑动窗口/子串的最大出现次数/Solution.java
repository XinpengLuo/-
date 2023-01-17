package 主要练习.滑动窗口.子串的最大出现次数;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - minSize + 1; i++){
            String temp = s.substring(i,i + minSize);
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < temp.length(); j++) {
                set.add(temp.charAt(j));
            }
            if(set.size() <= maxLetters)
            {
               map.put(temp,map.getOrDefault(temp,0) + 1);
               max = Math.max(map.get(temp),max);}
        }
        return max;
    }
    public int better(String s, int maxLetters, int minSize){
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character,Integer> time = new HashMap<>();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            time.put(s.charAt(i),time.getOrDefault(s.charAt(i),0) + 1);
            if(i >= minSize - 1){
                if(time.size() <= maxLetters){
                    String temp = s.substring(j,j + minSize);
                    map.put(temp,map.getOrDefault(temp,0) + 1);
                    max = Math.max(max,map.get(temp));
                }
                if(time.get(s.charAt(j)) == 1)
                    time.remove(s.charAt(j));
                else
                    time.put(s.charAt(j),time.get(s.charAt(j)) - 1);
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(solution.better("aabcabcab", 2, 2));
    }
}
