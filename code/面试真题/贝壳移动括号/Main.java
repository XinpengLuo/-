package 面试真题.贝壳移动括号;

import java.util.Scanner;

public class Main {
    public  static int getAnswer(String word){
        int count = 0;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '(')
                count++;
            else
                count--;
            if(count < 0)
                res = Math.min(res,count);
        }
        return res * -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int length = scanner.nextInt();
            String word = scanner.next();
            System.out.println(getAnswer(word));
        }
    }
}
