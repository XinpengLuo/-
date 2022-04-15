package 左神.暴力递归和动态规划.递归和回溯.刷题.灯泡开关;

public class Solution {
    public int bulbSwitch(int n) {
        boolean[] flags = new boolean[n];
        help(flags,n,1);
        int count = 0;
        for(int i = 0; i < flags.length; i++)
            if(flags[i])
                count++;
        return count;
    }
    public void help(boolean[] flags, int n, int curValue){
        if(curValue > n)
            return;
        for(int i = -1 + curValue; i < flags.length; i = i + curValue)
            flags[i] = !flags[i];
        help(flags,n,curValue + 1);
    }
    public int printAll(int n){
        if(n == 0)
            return 0;
        int time = 1;
        int start = 3;
        while (start < n){
            start = start + 3 + 2 * time;
            time++;
        }
        return time;
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        for(int i = 1; i < 999; i++)
            {System.out.println(solution.bulbSwitch(i) + " " + solution.printAll(i));
            }

    }
}