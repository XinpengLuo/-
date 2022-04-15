package 左神.字符串.最大单词长度乘积;

public class Solution {
    public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        for(int i = 0; i < words.length; i++)
            for(int j = 0; j < words[i].length(); j++)
                map[i] = map[i] | (1 << (words[i].charAt(j) - 'a'));
        int ans = 0;
        for(int i = 0; i < words.length; i++)
            for(int j = i + 1; j < words.length; j++){
                if((map[i] & map[j]) == 0)
                    ans = Math.max(ans,words[i].length() & words[j].length());
            }
        return ans;
    }
}
