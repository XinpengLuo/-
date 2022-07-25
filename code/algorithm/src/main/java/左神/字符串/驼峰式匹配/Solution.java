package 左神.字符串.驼峰式匹配;

import java.util.*;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for(String s : queries){
            int j = 0;
            boolean flag = true;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isUpperCase(c)){
                    if(j == pattern.length() || c != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                    else{
                        j++;
                    }
                }
                else{
                    if(j < pattern.length() && pattern.charAt(j) == c) {
                        j++;
                    }
                }
            }
            if(j != pattern.length()) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }
}
