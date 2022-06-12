package 左神.字符串.查找和替换模式;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if(isValid(word,pattern))
                res.add(word);
        }
        return res;
    }
    public boolean isValid(String word, String pattern){
        if(word.length() != pattern.length())
            return false;
        HashMap<Character,Character> mapBToA = new HashMap<>();
        HashMap<Character,Character> mapAToB = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            char a = word.charAt(i);
            char b = pattern.charAt(i);
            if(mapBToA.containsKey(b)){
                if(mapBToA.get(b) != a)
                    return false;
            }
            else if(mapAToB.containsKey(a))
            {
                if(mapAToB.get(a) != b)
                    return false;
            }
            else
              {
                  mapBToA.put(b,a);
                  mapAToB.put(a,b);
              }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
