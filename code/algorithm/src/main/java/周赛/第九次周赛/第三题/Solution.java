package 周赛.第九次周赛.第三题;

import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        long res = Long.MAX_VALUE;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        Arrays.sort(beans);
        for(int i = 0; i < beans.length; i++){
            long temp = (long)(beans.length - i) * (long)beans[i];
            res = Math.min(res,sum - temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,1,6,5};
        System.out.println(solution.minimumRemoval(arr));
    }
}
