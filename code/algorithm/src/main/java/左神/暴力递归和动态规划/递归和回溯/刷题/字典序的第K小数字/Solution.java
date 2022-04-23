package 左神.暴力递归和动态规划.递归和回溯.刷题.字典序的第K小数字;

public class Solution {
    int res = -1;
    int k;
    public int findKthNumber(int n, int k) {
        this.k = k;
        for(int i = 1; i <= 9; i++)
            help(n,i);
        return res;
    }
    public void help(int n, int temp) {
        if(temp > n || res != -1)
            return;
        k--;
        if(k == 0)
        {
            res = temp;
            return;
        }
        temp *= 10;
        for(int i = 0; i <= 9; i++)
            help(n,temp + i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(2, 2));
    }
}
