package 主要练习.数组和矩阵.刷题.第n位数字;

public class Solution {
    public int findNthDigit(int n) {
        int w = 1; //表示几位数 1代表1位数
        while (n > (9 * Math.pow(10,w - 1)) * w){
            n -= (9 * Math.pow(10,w - 1)) * w;
            w++;
        }
        int start = (int)Math.pow(10,w - 1);
        int mod = n % w;
        if(mod == 0)
            return (start + (n / w) - 1) % 10;

        start +=  (n / w);
        for(int i = 0; i < w - mod; i++)
            start = start / 10;
        return start % 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(1432));
    }
}
