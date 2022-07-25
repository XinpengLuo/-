package 面试真题.骰子子序列;

import java.util.*;

class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    public int shortestSequence(int[] rolls, int k) {
        dfs(rolls,0,new StringBuilder());
        for(int i = 1; i <= k; i++){
            int target = (int) Math.pow(k,i);
            if(map.get(i) < target)
                return i;
        }
        return -1;
    }
    public void dfs(int[] rolls, int index, StringBuilder sb){
        if(index == rolls.length){
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                map.put(sb.length(),map.getOrDefault(sb.length(),0) + 1);
            }
            return;
        }
        dfs(rolls, index + 1, sb);
        sb.append(rolls[index]);
        dfs(rolls, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}