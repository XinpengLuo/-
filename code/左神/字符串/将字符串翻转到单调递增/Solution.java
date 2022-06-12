package 左神.字符串.将字符串翻转到单调递增;

import 滴滴笔试.第一题.Main;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] count = new int[s.length()];
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1')
                temp++;
            count[i] = temp;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res,s.length() - temp);
        res = Math.min(res,temp);
        for(int i = 0; i < s.length(); i++){
            int left = count[i];
            int right = (s.length() - 1 - i - (count[count.length - 1] - count[i]));
            res = Math.min(res,left + right);
        }
        return res;
    }
    public int better(String s){
        int res = 0;
        int countOne = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '1')
                countOne++;
            else{
                res = Math.min(res + 1, countOne);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "01110";
        Solution solution = new Solution();
        solution.minFlipsMonoIncr(s);
    }
}
