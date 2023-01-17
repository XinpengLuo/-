package 主要练习.数组和矩阵.刷题.解码方法;

import java.util.HashMap;

public class Solution {
    public int numDecodings(String s) {
        HashMap<String,Character> hashMap = new HashMap<>();
        for(char temp = 'A'; temp <= 'Z'; temp++)
            hashMap.put(String.valueOf(temp - 64),temp);
        System.out.println(help(s,0,hashMap));
        return (dp(s,hashMap));
    }
    public int help(String str, int index, HashMap<String,Character> hashMap){
        if(index == str.length())
            return 1;
        int res = 0;
        for(int i = index; i < Math.min(str.length(),index + 3); i++)
           {
               if(hashMap.get(str.substring(index,i + 1)) != null)
                res += help(str,i + 1,hashMap);
           }
        return res;
    }
    public int dp(String str, HashMap<String,Character> hashMap){
        int[] dp = new int[str.length() + 1];
        dp[dp.length - 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            int res = 0;
            for(int j = i; j <= i + 2; j++){ //最多是两位数解码呀 其实这里还可以优化一下比如其实位置是0 则往后递归就是0种
                if(j >= str.length())
                    continue;
                if(hashMap.get(str.substring(i, j + 1)) != null)
                    dp[i] += dp[j + 1];
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
       Solution solution = new Solution();
        System.out.println(solution.numDecodings("1032311234512"));

    }
}
