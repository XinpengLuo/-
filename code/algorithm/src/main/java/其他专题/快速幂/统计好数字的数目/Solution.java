package 其他专题.快速幂.统计好数字的数目;

public class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        return (int)((myPow(5,even) * myPow(4,odd)) % mod);
    }
    public long myPow(int base, long n){
        long res = 1;
        for(int i = 0; i < n; i++) {
            res = (res * base) % mod;
        }
        return res;
    }
    public long fastPow(long base, long n){
        long res = 1;
        while(n > 0){
            if((n & 1) == 1){
                n--;
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            n = n / 2;
        }
        return res;
    }
    public long recurPow(long base, long n){
        if(n == 1)
            return base;
        if(n % 2 == 0)
            return recurPow(base * base % mod, n / 2);
        return (recurPow(base * base % mod, (n - 1) / 2) * base) % mod;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fastPow(2, 3));
    }
}
