package 主要练习.字符串.检测大写字母;


public class Solution {
    public boolean detectCapitalUse(String word) {
        int finalIndex = -1;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                finalIndex = i;
                count++;
            }
        }
        if(finalIndex == word.length() - 1 && count == word.length())
            return true;
        if(count == 1 && finalIndex == 0)
            return true;
        if(finalIndex == -1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("FlaG"));
    }
}
