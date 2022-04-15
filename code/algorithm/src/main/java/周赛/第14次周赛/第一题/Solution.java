package 周赛.第14次周赛.第一题;

import java.net.Socket;

public class Solution {
    public int convertTime(String current, String correct) {
        if(current.equals(correct))
            return 0;
        int a = Integer.parseInt(current.substring(0,2));
        int b = Integer.parseInt(correct.substring(0,2));
        int c = Integer.parseInt(current.substring(3,5));
        int d = Integer.parseInt(correct.substring(3,5));
        if(c < d)
            return (b - a) + getMinOp(d -c);
        else if(c > d)
            return (b - a - 1) + getMinOp(60 - (c - d));
        else
            return b - a;
    }
    public int getMinOp(int value){
        int count = 0;
        while (value != 0){
            if(value >= 15){
                count += (value / 15);
                value = value % 15;
            }
            else if(value >= 5){
                count += (value / 5);
                value = value % 5;
            }
            else{
                count += (value / 1);
                value = value % 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertTime("01:42", "02:42"));
    }
}
