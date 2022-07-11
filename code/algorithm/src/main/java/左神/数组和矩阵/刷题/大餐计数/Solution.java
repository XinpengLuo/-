package 左神.数组和矩阵.刷题.大餐计数;

import java.util.*;

public class Solution {
    public int countPairs(int[] deliciousness) {
        int res = 0;
        int mod = 1000000007;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : deliciousness) {
            for(int j = 0; j < 31; j++){
                res += map.getOrDefault((1 << j) - i,0);
                res %= mod;
            }
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        return res;
    }
}
