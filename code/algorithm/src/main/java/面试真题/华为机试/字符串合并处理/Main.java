package 面试真题.华为机试.字符串合并处理;

import java.util.*;

public class Main {
    public String merge(String s1, String s2){
        String temp = s1 + s2;
        char[] odd = new char[temp.length() / 2];
        char[] even = new char[temp.length() - odd.length];
        //5 0 1 2 3 4 0 1  2 3
        for(int i = 0; i < temp.length(); i++){
            if((i & 1) == 0)
                even[i / 2] = temp.charAt(i);
            else
                odd[i / 2] = temp.charAt(i);
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        char[] ans = new char[temp.length()];
        for(int i = 0; i < temp.length(); i++){
            char c;
            if((i & 1) == 0)
                c = even[i / 2];
            else
                c = odd[i / 2];
            if(c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || c >= '0' && c <= '9'){
                int num = c - '0';
                if(c >= 'a' && c <= 'f')
                    num =  (c - 'a' + 10);
                else if(c >= 'A' && c <= 'F')
                    num = c - 'A' + 10;
                num = reverseNum(num);
                if(num > 9)
                    c = (char) ('A' + num - 10);
                else
                    c = (char) (num + '0');
            }

            ans[i] = c;
        }
        return new String(ans);
    }
    public int reverseNum(int num){
        int res = 0;
        for(int i = 0; i < 4; i++){
            if(((1 << i) & num) != 0)
                res += (1 << (3 - i));
        }
        return res;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(main.merge(s1,s2));
    }
}
