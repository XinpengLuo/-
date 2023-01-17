package 主要练习.位运算.配对交换;

import java.util.*;

public class Solution {
    public int exchangeBits(int num) {
        int res = 0;
        int index = 0;
        while(index <= 31){
            int a = (num & (1 << index)) != 0 ? 1 : 0;
            int b = (num & (1 << (index + 1))) != 0 ? 1 : 0;
            res += (b << index);
            res += (a << (index + 1));
            index += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Character> temp = new ArrayList<>();
        System.out.println(solution.countHomogenous("abbcccaa"));
    }
    public int countHomogenous(String s) {
        int count = 0;
        int mod = 1000000007;
        int j = 0;
        char target = ' ';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(target == ' ' || c == target)
            {
                target = c;
                continue;
            }
            target = c;
            int len = i - j;
            count += ((len)  * (len + 1) / 2) % mod;
            j = i;
        }
        return count;
    }
}
