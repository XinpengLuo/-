package 左神中级班.第一节.打表法.先手后手吃草;

public class Solution {
    public static String winner(int n){
        if(n < 5)
            return (n == 0 || n == 2) ? "后手" : "先手";
        int base = 1;
        while (base <= n){
            if(winner(n  - base).equals("后手"))
                return "先手";
            if(base > n / 4)
                break;
            base *= 4;
        }
        return "后手";
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(winner(i));
        }
    }
}
