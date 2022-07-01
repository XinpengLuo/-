package 面试真题.华为机试.特殊的递增序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
public class Main {
    List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = scanner.nextInt();
        for(int i = 0; i < num - count; i++)
        {
            int sum = 0;
            for(int j = 0; j < count; j++)
                sum += (i + j);
            if(sum == num){
                for(int j = 0; j < count; j++)
                    System.out.println(i + j);
            }
        }
    }

}
