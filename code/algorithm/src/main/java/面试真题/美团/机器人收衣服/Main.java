package 面试真题.美团.机器人收衣服;

import java.util.*;

public class Main {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), b = scanner.nextInt();
        int[] energy = new int[n];
        int[] time = new int[n];
        for(int i = 0; i < energy.length; i++)
            energy[i] = scanner.nextInt();
        for(int i = 0; i < time.length; i++)
            time[i] = scanner.nextInt();
        if(energy[0] > b)
            System.out.println(-1);
        else{
            dfs(energy, time, b - energy[0],1,0,0);
            System.out.println(res);
        }
    }
    //            3 5
//            1 2 3
//            7 5 3
    public static void dfs(int[] energy, int[] time, int b, int index, int pre, int sum){
        if(index == time.length){
            res = Math.min(res,Math.max(sum ,  (index - pre) * time[pre]));
            return;
        }
        if(energy[index] <= b){
            dfs(energy,time,b - energy[index],index + 1,index, Math.max(sum ,  (index - pre) * time[pre]));
        }
        dfs(energy,time,b,index + 1,pre,sum);
    }

}

