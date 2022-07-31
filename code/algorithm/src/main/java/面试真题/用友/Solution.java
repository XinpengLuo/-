package 面试真题.用友;

import java.util.*;

/**
 * @author luoxinpeng
 */
public class Solution {
    public static void main(String[] args) {
        int[][] res = new int[2][2];
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
    }
}
