package 面试真题.华为机试.最长公共子串;

import java.util.Scanner;

public class Main {
    public static String maxCommonString(String s1, String s2){
        String temp = s1.length() <= s2.length() ? s1 : s2;
        if(!temp.equals(s1)){
            s2 = s1;
            s1 = temp;
        }
        int[][] dp = new int[s1.length()][s2.length()];
        int res = 0;
        String ans = "";
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i >= 1 && j >= 1)
                        dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j]++;
                }
                if(dp[i][j] > res){
                    res = dp[i][j];
                    //为什么是 i - (dp[i][j] - 1) 如果最长公共长度为1 那么他不用往后数 如果是2 往后面数一个
                    //截取到i + 1位置 因为是开区间
                    ans = s1.substring(i - (dp[i][j] - 1),i + 1);
                }
            }
        return ans;
    }

    public static void main(String[] args) {

//        Main main = new Main();
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println(maxCommonString(s1,s2));
    }
}
