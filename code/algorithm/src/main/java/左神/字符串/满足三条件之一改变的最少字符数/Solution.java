package 左神.字符串.满足三条件之一改变的最少字符数;

import java.util.*;

public class Solution {
    public int minCharacters(String a, String b) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            count2[b.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(i != 0) {
                res = Math.min(help(i, count1, count2), res);
                res = Math.min(help(i, count2, count1), res);
            }
            res = Math.min(res,count(count1,i) + count(count2,i));
        }
        return res;
    }
    public int help(int i, int[] count1, int[] count2){
        int change = 0;
        for(int j = i; j < 26; j++)
            change += count1[j];
        for(int j = 0; j < i; j++)
            change += count2[j];
        return change;
    }
    public int count(int[] count, int target){
        int sum = 0;
        for(int i = 0; i < count.length; i++)
            if(i != target)
                sum += count[i];
        return sum;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aab";
        Solution solution = new Solution();
        System.out.println(solution.minCharacters(a, b));
    }
}
