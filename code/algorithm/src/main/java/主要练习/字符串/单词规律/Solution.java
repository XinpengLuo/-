package 主要练习.字符串.单词规律;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        HashMap<Character,String> hashMap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            Character temp = pattern.charAt(i);
            if(!hashMap.containsKey(temp)){
                if(!hashMap.containsValue(str[i]))
                    hashMap.put(temp,str[i]);
                else
                    return false;
            }
            else{
                if(!hashMap.get(temp).equals(str[i]))
                    return false;
            }
        }

        return true;
    }
}
