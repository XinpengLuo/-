package 左神.位运算.统计一致字符串的数目;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int target = getNumberOfString(allowed);
        int res = 0;
        for(int i = 0; i < words.length; i++){
            int temp = getNumberOfString(words[i]);
            if((temp & target) == temp) //如果刚好相等那么正好 如果只是比预期的少就是等于他自己 比预期的多就就会出现数字减少
                res++;
        }
        return res;
    }
    public int getNumberOfString(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            res |= (1 << index);
        }
        return res;
    }
}