package 左神.暴力递归和动态规划.动态规划.刷题.将数字变成0的操作次数;

public class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0){
            if(num % 2 == 0)
                num = num / 2;
            else
                num--;
            count++;
        }
        return count;
    }
}
