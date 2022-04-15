package 左神.字符串.单词演变;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for (String s : wordList) {
            if(s.equals(endWord))
                flag = true;
        }
        if(!flag)
            return 0;
        int res = help(beginWord,endWord,wordList) + 1;
        System.out.println(res);
        return res < 0 ? 0 : res;
    }
    public int help(String beginWord, String endWord,List<String> wordList){
        if(isOne(beginWord,endWord) == 1)
            {
                System.out.println(beginWord);
                return 1;
            }
        int res = 10000;
        for (int i = 0; i < wordList.size(); i++) {
            String temp = wordList.get(i);
            if(temp != "" && isOne(temp,beginWord) == 1){
                wordList.set(i,"");
                res = Math.min(res,1 + help(temp,endWord,wordList));
                wordList.set(i,temp);
            }
        }
        return res;
    }
    public int isOne(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("cog");
        list.add("dot");
        list.add("dog");
        list.add("hit");
        list.add("lot");
        list.add("log");
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, list));

    }
}
