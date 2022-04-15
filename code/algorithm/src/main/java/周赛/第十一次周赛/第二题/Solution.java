package 周赛.第十一次周赛.第二题;

import 左神.树专题.视频.消息体处理.求二叉树的最大值和最小值.MaxAndMinValue;

public class Solution {
    public int minSteps(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            cnt2[t.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < cnt1.length; i++)
            ans += Math.abs(cnt1[i] - cnt2[i]);
        return ans;
    }
}
