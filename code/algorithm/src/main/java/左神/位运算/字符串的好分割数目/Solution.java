package 左神.位运算.字符串的好分割数目;

import java.util.HashSet;

public class Solution {
    public int numSplits(String s) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        HashSet<Character> setLeft = new HashSet<>();
        HashSet<Character> setRight = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            setLeft.add(s.charAt(i));
            setRight.add(s.charAt(s.length() - 1 - i));
            left[i] = setLeft.size();
            right[s.length() - 1 - i] = setRight.size();
        }
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(left[i - 1] == right[i])
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        Solution solution = new Solution();
        System.out.println(solution.numSplits(s));
    }
}
