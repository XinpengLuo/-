package 其他专题.快速幂.pow;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long temp = Math.abs((long)n);
        while(temp > 0){
            if(temp % 2 != 0)
                res *= x;
            x = x * x;
            temp /= 2;
        }
        return n >= 0 ? res : 1.0 / res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, -2147483648));
    }
}
