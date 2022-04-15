package 左神.数组和矩阵.刷题.相对名次;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] temp = {"Gold Medal","Silver Medal","Bronze Medal"};
        int[] clone = score.clone();
        Arrays.sort(clone);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < clone.length; i++)
            map.put(clone[i],score.length - i);
        String[] ans = new String[score.length];
        for(int i = 0; i < score.length; i++){
            int rank = map.get(score[i]);
            ans[i] = rank <= 3 ? temp[rank - 1] : rank + "";
        }
        return ans;
    }
}
