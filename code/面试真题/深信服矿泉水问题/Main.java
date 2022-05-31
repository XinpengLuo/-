package 面试真题.深信服矿泉水问题;

import java.util.*;
public class Main{
    public static int better(int target, int a, int b){
        int c = 3 * a >= b ? b : 3 * a;
        int res = 0;
        res += (target / 1500) * c;
        int remind = target % 1500;
        if(remind != 0)
            res += Math.min((remind / 500 + (remind % 500 == 0 ? 0 : 1)) * a ,b);
        return res;
    }
    public static int good(int x, int a, int b){
        int ans1 = 0, ans2 = 0, ans3 = 0;
        if (a <= b / 3) {
            ans1 = (x + 500 - 1) / 500 * a;
            return ans1;
        } else {
            ans2 = (x + 1500 - 1) / 1500 * b;//全买大水
            ans3 = x / 1500 * b + ((x % 1500) + 500 - 1) / 500 * a;//
        }
        return (Math.min(ans2, ans3));
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int target = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(better(target,a ,b) != good(target,a,b))
               {
                   System.out.println(target + " " + a +  " " + b); //312299 24359322 468448500
                   System.out.println(better(target,a,b));
                   System.out.println(good(target,a,b));
               }

        }
    }
}