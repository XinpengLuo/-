package 面试真题.网易摩尔斯电码解码;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public int getAnswer(String word, int index){
        if(index == word.length())
            return 1;
        int res = 0;
        res += getAnswer(word, index + 1);
        if(index + 2 <= word.length()){
            String temp = word.substring(index,index + 2);
            int num = Integer.parseInt(temp);
            if(num == 10 || num == 11)
                res += getAnswer(word,index + 2);
        }
        if(index + 3 <= word.length()){
            String temp = word.substring(index,index + 3);
            int num = Integer.parseInt(temp);
            if(num == 100 || num == 101 || num == 110 || num == 111)
                res += getAnswer(word,index + 3);
        }
        return res;
    }
    public long dp(String word){
        long[] dp = new long[word.length() + 1];
        dp[dp.length - 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            long res = 0;
            res += dp[i + 1];
            if(i + 2 <= word.length()){
                String temp = word.substring(i, i + 2);
                int num = Integer.parseInt(temp);
                if(num == 10 || num == 11)
                    res += dp[i + 2];
            }
            if(i + 3 <= word.length()){
                String temp = word.substring(i, i + 3);
                int num = Integer.parseInt(temp);
                if(num == 100 || num == 101 || num == 110 || num == 111)
                    res += dp[i + 3];
            }
            dp[i] = res;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        String word = "aaabbaaac";
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.dp(str));
    }
}
