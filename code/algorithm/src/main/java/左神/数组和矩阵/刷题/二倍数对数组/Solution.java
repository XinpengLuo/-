package 左神.数组和矩阵.刷题.二倍数对数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        if(map.getOrDefault(0,0) % 2 != 0)
            return false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            arrayList.add(key);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Math.abs(a) - Math.abs(b);
            }
        });
        for (Integer key : arrayList) {
            if(map.get(key) == 0)
                continue;
            if(map.get(key) > map.getOrDefault(2 * key, 0))
                return false;
            map.put(2 * key, map.get(2 * key) - map.get(key));
        }
        return true;
    }
}
