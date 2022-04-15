package leetcode.最富有客户的资产总量;

import java.util.Arrays;

public class RichClient {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{4,5,6}};
        int max = 0;
        int sum = 0;

        for (int[] account : accounts) {
            sum = 0;
            for (int i : account) {
                sum += i;
            }
            max = Math.max(sum,max);
        }
    }
}
