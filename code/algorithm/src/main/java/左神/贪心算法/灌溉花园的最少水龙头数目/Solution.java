package 左神.贪心算法.灌溉花园的最少水龙头数目;

import java.util.*;

public class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] temp = new int[ranges.length][2];
        for(int i = 0; i < ranges.length; i++){
            int left = Math.max(0,i - ranges[i]);
            int right = i + ranges[i];
            temp[i][0] = left;
            temp[i][1] = right;
        }
        Arrays.sort(temp,(t1,t2) -> {
            if(t1[0] == t2[0])
                return t1[1] - t2[1];
            return t1[0] - t2[0];
        });
        int cover = 0, count = 0, index = 0;
        while(index < temp.length){
            int last = 0;
            while(index < temp.length && temp[index][0] <= cover){
                last = Math.max(temp[index][1],last);
                index++;
            }
            if(last == 0)
                return -1;
            cover = last;
            count++;
            if(cover >= n)
                return count;
        }
        return cover >= n ? count : -1;
    }

}
