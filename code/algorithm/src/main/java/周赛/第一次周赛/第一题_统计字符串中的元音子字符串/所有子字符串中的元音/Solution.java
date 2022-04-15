package 周赛.第一次周赛.第一题_统计字符串中的元音子字符串.所有子字符串中的元音;

public class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; i + j < word.length(); j++){
               if(countTemp(word,j,i + j))
                   count++;
            }
        }
        return count;
    }
    public boolean countTemp(String word, int start, int end){
        int ans = 0;
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for(int k = start; k <= end; k++){
            char temp = word.charAt(k);
            if(temp == 'a')
                a++;
            else if(temp == 'e')
                e++;
            else if(temp == 'i')
                i++;
            else if(temp == 'o')
                o++;
            else if(temp == 'u')
                u++;
            else
                return false;
        }
        if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0)
            return true;
        return false;
    }
    public boolean isValid(String word){

        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for(int j = 0; j < word.length(); j++){
            char temp = word.charAt(j);
            if(temp == 'a')
                a++;
            else if(temp == 'e')
                e++;
            else if(temp == 'i')
                i++;
            else if(temp == 'o')
                o++;
            else if(temp == 'u')
                u++;
            else
                return false;

        }
        if(a > 0 && e > 0 && i > 0 && o > 0 && u > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelSubstrings("cuaieuouac"));
    }

}
