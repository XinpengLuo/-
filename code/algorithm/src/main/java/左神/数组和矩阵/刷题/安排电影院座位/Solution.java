package 左神.数组和矩阵.刷题.安排电影院座位;

import java.util.*;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            if(!map.containsKey(row))
                map.put(row,new HashSet<Integer>());
            map.get(row).add(col);
        }
        int count = 2 * n;
        for (Integer row : map.keySet()) {
            HashSet<Integer> cols = map.get(row);
            int temp = 0;
            if(isValid(2,5,cols)){
                temp++;
                if(isValid(6,9,cols))
                    temp++;
            }
            else if(isValid(4,7,cols))
                temp++;
            else if(isValid(6,9,cols))
                temp++;
            count -= (2 - temp);
        }
        return count;
    }
    public boolean isValid(int left, int right, HashSet<Integer> set){
        for(int i = left; i <= right; i++)
            if(set.contains(i))
                return false;
        return true;
    }
}
