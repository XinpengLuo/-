package 左神.字符串.重复的DNA序列;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        HashMap<String,Integer> hashMap = new HashMap<>(); // 字符串 -- 》 出现次数
        for (int i = 0; i < s.length(); i++) {
            if(i + 10 > s.length())
                break;
            String temp = s.substring(i,i + 10);
            System.out.println(temp);
            if(hashMap.containsKey(temp)){
                if(hashMap.get(temp) == 1)
                    res.add(temp);
                hashMap.put(temp,hashMap.get(temp) + 1);
            }
            else
                hashMap.put(temp,1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String aaaaaaaaaaaaa : solution.findRepeatedDnaSequences("AAAAAAAAAAA")) {
            System.out.println(1);
        }
    }
}
