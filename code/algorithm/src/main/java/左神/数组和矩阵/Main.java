package 左神.数组和矩阵;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[i].length; j++)
                arr[i][j] = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        res.add(arr[0][0]);
        boolean flag = true;
        int x1 = 0, y1 = 1, x2 = 1, y2 = 0;
        while(res.size() < n * n){
            if(flag){
                int i = x1, j = y1;
                while(i <= x2 && j >= y2){
                    res.add(arr[i][j]);
                    i++;
                    j--;
                }
            }
            else{
                int i = x2, j = y2;
                while(i >= x1 && j <= y1){
                    res.add(arr[i][j]);
                    i--;
                    j++;
                }
            }
            if(y1 + 1 < n)
                y1++;
            else
                x1++;
            if(x2 + 1 < n)
                x2++;
            else
                y2++;
            flag = !flag;
        }
        for(int k = 0; k < res.size(); k++)
            System.out.print(res.get(k) + " ");
    }
}