package 左神.字符串.单词拆分2;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        help(s,wordDict,0,"");
        return res;
    }
    public void help(String s, List<String> wordDict, int index, String temp){
        if(index == s.length()){
            res.add(temp.trim());
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(wordDict.contains(s.substring(index,i + 1)))
                help(s,wordDict,index + 1,temp + " " + s.substring(index,i + 1));
        }
    }
}
