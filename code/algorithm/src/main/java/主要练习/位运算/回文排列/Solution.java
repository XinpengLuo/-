package 主要练习.位运算.回文排列;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        long temp = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            temp ^= (1 << index);
        }
        if(temp == 0 || Long.bitCount(temp) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1 << ('/' - 'a'));
    }
}
