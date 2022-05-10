package 面试真题.贝壳木棒;

import java.util.Scanner;

public class Main {
    public static int getAnswer(int n){
        if(n == 1)
            return 1;
        if(n % 2 == 0)
            return n / 2;

        return n / 2 + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println(getAnswer(scanner.nextInt()));
        }
    }
}
