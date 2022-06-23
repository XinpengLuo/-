package 左神.滑动窗口.串联所有单词的子串;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i < s.length() - words.length * words[0].length() + 1; i++){
            HashMap<String,Integer> temp = new HashMap<>();
            boolean flag = true;
            for(int j = 0; j < words.length; j++){
                int start = i + j * words[0].length();
                String str = s.substring(start, start + words[0].length());
                temp.put(str,temp.getOrDefault(str,0) + 1);
                if(!map.containsKey(str) || temp.get(str) > map.get(str))
                    {
                        flag = false;
                        break;
                    }
            }
            if(flag)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        Solution solution = new Solution();
        List<Integer> list = solution.findSubstring(s, words);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
