package 主要练习.暴力递归和动态规划.动态规划.刷题.弱角色的数量;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        //按攻击力递减 防御力递增
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] != t2[1] ? t2[1] - t1[1] : t1[0] - t2[0];
            }
        });
        int count = 0;
        int maxPre = properties[0][0];
        for(int i = 1; i < properties.length; i++){
            if(properties[i][0] < maxPre)
                count++;
            maxPre = Math.max(maxPre,properties[i][0]);
        }
        return count;
    }
}
