package 左神.暴力递归和动态规划.递归和回溯.刷题.救生艇;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0, left = 0, right = people.length - 1;
        while (left <= right){
            if(people[left] + people[right] > limit)
                right = right - 1;
            else{
                left++;
                right--;
            }
            res++;
        }
        return res;
    }

}
