package 左神.位运算.找出最长的超赞子字符串;

import java.util.Arrays;

public class Solution {
    public int longestAwesome(String s) {
        int res = 0;
        int[] map = new int[1024];
        Arrays.fill(map, - 1);
        int state = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - '0';
            state = state ^ (1 << index);
            int countOne = countBitOne(state);
            if(state == 0 ||countOne == 1){
                res = Math.max(res, i + 1);
                if(countOne == 1 && map[state] == -1)
                    map[state] = i;
            }
            else{
                if(map[state] != -1)
                    res = Math.max(res, i - map[state]);
                for(int j = 0; j < 10; j++){
                    int temp = state ^ (1 << j);
                    if(map[temp] != -1){
                        res = Math.max(res, i - map[temp]);
                    }
                }
                if(map[state] == -1){
                    map[state] = i;
                }
            }
        }
        return res;
    }
    public int countBitOne(int state){
        int count = 0;
        while(state != 0){
            state &= (state - 1);
            count++;
        }
        return count;
    }
}
