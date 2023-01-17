package 主要练习.位运算.最美子字符串的数目;

import java.util.HashMap;

public class Solution {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int state = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < word.length(); i++) {
            state = state ^ (1 << (word.charAt(i) - 'a'));
            res += map.getOrDefault(state,0);
            for(int j = 0; j < 10; j++){
                int temp = state ^ (1 << j);
                res += map.getOrDefault(temp,0);
            }
            map.put(state,map.getOrDefault(state,0) + 1);
        }
        return res;
    }
    public long better(String word){
        long res = 0;
        int state = 0;
        int[] map = new int[1024];
        map[0] = 1;
        for(int i = 0; i < word.length(); i++){
            state = state ^ (1 << (word.charAt(i) - 'a'));
            res += map[state];
            for(int j = 0; j < 10; j++){
                int temp = state ^ (1 << j);
                res += map[temp];
            }
            map[state]++;
        }
        return res;
    }
}
