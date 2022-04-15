package 左神.字符串.最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for(int i = 0; i < strs[0].length(); i++){
            String temp = strs[0].substring(0,i + 1);
            boolean flag = true;
            for(int j = 1; j < strs.length; j++)
                if(!strs[j].startsWith(temp)){
                    flag = false;
                    break;
                }
            if(flag && temp.length() > res.length())
                res = temp;
        }
        return res;
    }
}
