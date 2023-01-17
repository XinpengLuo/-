package 笔试.滴滴笔试.第二题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String source = scanner.next();
            String target = scanner.next();
            while(true){
                String replace = s.replaceFirst(source, target);
                if(replace.equals(s))
                    break;
                s = new String(replace);
            }
        }
        System.out.println(s);
    }
}
