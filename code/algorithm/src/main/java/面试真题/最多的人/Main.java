package 面试真题.最多的人;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] rules = new int[m][3];
        for(int i = 0; i < m; i++){
            rules[i][0] = scanner.nextInt();
            rules[i][1] = scanner.nextInt();
            rules[i][2] = scanner.nextInt();
        }
        Arrays.sort(rules, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int count = n, index = 0 , pre = 1;
        while(index < rules.length){
            int left = Math.max(rules[index][0],pre);
            int right = rules[index][1];
            int num = rules[index][2];
            index++;
            if(right - left + 1 <= num)
                continue;
            count = count - (right - left + 1 - num);
            pre = right + 1;

        }
        System.out.println(count);
    }

}