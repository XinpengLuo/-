package 面试真题.滴滴数字;

import java.util.*;

public class Main {
    static String res = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        res = s;
        dfs(s,0,"");
        System.out.println(res);
    }
    public static boolean dfs(String s, int index, String ans){
        if(index == s.length()){
            long sum = 0;
            for(int i = 0; i < ans.length(); i++)
                sum +=  (ans.charAt(i) - '0');
            if(sum % 3 != 0)
                return false;
            if(res.equals(""))
                res = ans;
            else{
                if(res.compareTo(ans) > 0)
                    res = ans;
            }
            return true;
        }
        char c = s.charAt(index);
        if(c != '?')
            dfs(s,index + 1,ans + c);
        else{
            char next = index + 1 < s.length() ? s.charAt(index + 1) : '%';
            char pre = index - 1 >= 0 ? s.charAt(index - 1) : '%';
            if(index == 0){
                for(char n = '1'; n <= '9'; n++) {
                    if(n != next)
                        if(dfs(s, index + 1, ans + n))
                            return true;
                }
            }
            else{
                for(char n = '0'; n <= '9'; n++) {
                    if(n != next && n != pre)
                        if(dfs(s, index + 1, ans + n))
                            return true;
                }
            }
        }
        return false;
    }
}
