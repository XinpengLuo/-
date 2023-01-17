package 主要练习.字符串.最长字符串链;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int longestStrChain(String[] words) {
        //直接写动态规划把 没什么好递归的了
        Arrays.sort(words,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (String word : words) {
            System.out.println(word);
        }
        int max = 0;
        int[] dp = new int[words.length];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            int temp = 0;
            for(int j = 0; j < i; j++)
                if(isValid(words[j], words[i]))
                    temp = Math.max(dp[j] + 1,temp) ;
                else
                    temp = Math.max(temp,1);
            dp[i] = temp;
            max = Math.max(max,dp[i]);
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return max;
    }
    public boolean isValid(String word1, String word2){
        if(word2.length()-word1.length()!=1)return false;
        int flag=0;
        int i=0,j=0;
        while(i<word1.length()&&j<word2.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }else{
                flag++;
                j++;
                if(flag>1)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"bdca","bda","ca","dca","a"};
        Solution solution = new Solution();
        System.out.println(solution.longestStrChain(words));
    }
}
