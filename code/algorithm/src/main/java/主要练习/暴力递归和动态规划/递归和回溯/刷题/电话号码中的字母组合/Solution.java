package 主要练习.暴力递归和动态规划.递归和回溯.刷题.电话号码中的字母组合;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
        {
            return result;
        }
        HashMap<Character, String> phoneMap = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        String[] letters = new String[digits.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = phoneMap.get(digits.charAt(i));
        }
        getResult(0,result,letters,"");
        return result;
    }
    public void getResult(int index, List<String> result, String[] letters, String temp){
        if(index > letters.length)
            return;
        if(index == letters.length){
            result.add(temp);
            return;
        }
        for (int i = 0; i < letters[index].length(); i++) {
            getResult(index + 1,result,letters,temp + letters[index].charAt(i));
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String letterCombination : solution.letterCombinations("23")) {
            System.out.println(letterCombination);
        }
    }
}
