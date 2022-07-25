package 左神.位运算.与数组中元素的最大抑或值;

import 左神.树专题.视频.前缀树.Trie;

/**
 * @author luoxinpeng
 */
public class Solution {
    TrieNode root = new TrieNode();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < nums.length; i++){
            insert(nums[i]);
        }
        int index = 0;
        for (int[] query : queries) {
            int temp = search(query[0],query[1]);
            if(temp == -1){
                res[index] = -1;
            }
            else{
                res[index] = query[0] ^ temp;
            }
            index++;
        }
        return res;
    }
    public int search(int num, int min){
        TrieNode temp = root;
        int val = 0;
        for(int i = 31; i >= 0; i--){
            int target = ((num >> i) & 1) ^ 1;
            if(temp.next[target] != null && temp.next[target].min <= min) {
                temp = temp.next[target];
            }
            else{
                target = target ^ 1;
                if(temp.next[target] == null || temp.next[target].min > min) {
                    return -1;
                }
                temp = temp.next[target];
            }
            val += (target << i);
        }
        return val;
    }
    public void insert(int num){
        TrieNode temp = root;
        for(int i = 31; i >= 0; i--){
            int target = (num >> i) & 1;
            if(temp.next[target] == null) {
                temp.next[target] = new TrieNode();
            }
            temp = temp.next[target];
            temp.min = Math.min(temp.min,num);
        }
    }
}
class TrieNode{
    TrieNode[] next;
    int min;
    public TrieNode(){
        next = new TrieNode[2];
        min = Integer.MAX_VALUE;
    }
}
