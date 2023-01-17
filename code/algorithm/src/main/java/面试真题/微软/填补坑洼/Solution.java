package 面试真题.微软.填补坑洼;

import java.util.*;

public class Solution {
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 8 (Java SE 8)
        Arrays.sort(X);
        int index = 0, count = 0;
        while(index < X.length){
            count++;
            int start = X[index];
            while(index < X.length && X[index] <= start + W)
                index++;
        }
        return count;
    }
}