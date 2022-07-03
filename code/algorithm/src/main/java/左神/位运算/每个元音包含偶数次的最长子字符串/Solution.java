package 左神.位运算.每个元音包含偶数次的最长子字符串;

import java.util.Arrays;

public class Solution {
    public int findTheLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        int[] map = new int[32]; //5个字符 32种状态
        Arrays.fill(map,-1);
        int state = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = getIndex(c);
            if(index != -1) //如果是元音字符 则对应的字符的奇偶性进行反转
                state = state ^ (1 << index);
            if(state == 0) //如果反转后依然满足全是偶数 那么整个字符串就是最长的
            {
                res = Math.max(res, i + 1);
                continue;
            }
            if(map[state] == -1) //如果当前字符的状态压缩不是全是0 即有的是奇数 且这个状态没有出现过 因为奇数相减等于偶数
            {
                map[state] = i; //那么记录此状态 且后面不用更新 因为求最长的
                continue;
            }
            res = Math.max(res, i - map[state]); //当前有的字符是奇数 但是之前有出现过这种状态 则求此区间的长度即可
        }
        return res;
    }
    public int getIndex(char c){
        if(c == 'a')
            return 0;
        else if(c == 'e')
            return 1;
        else if(c == 'i')
            return 2;
        else if(c == 'o')
            return 3;
        else if(c == 'u')
            return 4;
        return -1;
    }

    public static void main(String[] args) {
        String s = "yopumzgd";
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestSubstring(s));
    }
}
