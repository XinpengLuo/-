package 左神.字符串.活字印刷;

import java.util.HashSet;

public class Solution {
    HashSet<String> hashSet = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        boolean[] flags = new boolean[tiles.length()];
        return help(tiles.toCharArray(),0,flags,"");
//        return hashSet.size();
    }
    public int help(char[] chars, int index, boolean[] flags, String temp){
        if(index >= chars.length){
            if(!temp.equals("") && hashSet.add(temp))
                {
                    return 1;}
            return 0;
        }
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!flags[i]){
                flags[i] = true;
                res += help(chars,index + 1,flags, temp + chars[i]);
                res += help(chars,index + 1,flags,temp);
                flags[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AAB";
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities(s));
    }
}
