package 周赛.第303场周赛.优质对的数目;

import 左神.树专题.视频.前缀树.Trie;

import java.util.*;

public class Solution {
    TrieNode root = new TrieNode();
    public long countExcellentPairs(int[] nums, int k) {
        long count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            set.add(num);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer integer : set) {
            int temp = Integer.bitCount(integer);
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        for (Integer integer : set) {
            int temp = Integer.bitCount(integer);
            if(temp >= k) {
                count += set.size();
            }
            else{
                for (Integer key : map.keySet()) {
                    if(key + temp >= k) {
                        count += map.get(key);
                    }
                }
            }
        }
        return count;
    }
}
class TrieNode{
    int num;
    TrieNode[] next;
    int end;
    public TrieNode(){
        next = new TrieNode[2];
        end = 0;
    }
}
